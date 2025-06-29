package br.com.devance.fonar.servicos;

import br.com.devance.fonar.dto.*;
import br.com.devance.fonar.enums.Status;
import br.com.devance.fonar.excecoes.ExcecaoRecursoNaoEncontrado;
import br.com.devance.fonar.mappers.FonarMapper;
import br.com.devance.fonar.models.Delegacia;
import br.com.devance.fonar.models.Fonar;
import br.com.devance.fonar.models.Usuario;
import br.com.devance.fonar.repositorios.RepositorioDelegacia;
import br.com.devance.fonar.repositorios.RepositorioFonar;
import br.com.devance.fonar.repositorios.RepositorioUsuario;
import br.com.devance.fonar.repositorios.RepositorioVitima;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ServicoFonar {

    @Autowired
    private RepositorioFonar repositorioFonar;

    @Autowired
    private RepositorioVitima repositorioVitima;
    @Autowired
    private RepositorioDelegacia repositorioDelegacia;
    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @Transactional
    public DTOSaidaFonar registrarFonarOnline(DTOEntradaFonar dtoEntradaFonar) {
        if (!repositorioVitima.existsByCpf(dtoEntradaFonar.getCpfVitima())) {
            throw new ExcecaoRecursoNaoEncontrado("Vítima com CPF " + dtoEntradaFonar.getCpfVitima() + " não encontrada no sistema.");
        }

        // Mapeia o DTO para entidade usando o mapper centralizado
        Fonar fonar = FonarMapper.toEntity(dtoEntradaFonar);

        // Ajustes específicos do fluxo online (sem delegacia e responsável)
        fonar.setStatusTriagem(Status.CRIADA);
        fonar.setDataRegistro(LocalDate.now());

        Fonar fonarSalvo = repositorioFonar.save(fonar);

        // Retorna DTO de resposta
        return FonarMapper.toResponseDTO(fonarSalvo);
    }

    @Transactional
    public DTOSaidaFonar registrarNovoFonar(DTOEntradaFonar dtoEntradaFonar, Delegacia delegacia, Usuario usuario) {
        if (!repositorioVitima.existsByCpf(dtoEntradaFonar.getCpfVitima())) {
            throw new ExcecaoRecursoNaoEncontrado("Vítima com CPF " + dtoEntradaFonar.getCpfVitima() + " não encontrada no sistema.");
        }

        // Mapeia o DTO para entidade usando o mapper centralizado
        Fonar fonar = FonarMapper.toEntity(dtoEntradaFonar);

        // Ajustes específicos do fluxo profissional (com delegacia e responsável)
        fonar.setStatusTriagem(Status.CRIADA);
        fonar.setDataRegistro(LocalDate.now());
        fonar.setDelegacia(delegacia);
        fonar.setResponsavel(usuario.getCpf());

        Fonar fonarSalvo = repositorioFonar.save(fonar);

        // Retorna DTO de resposta
        return FonarMapper.toResponseDTO(fonarSalvo);
    }

    public List<DTOHistoricoFonar> obterHistoricoFonarVitima(String cpfVitima, DTOFiltroFonar filtros) {
        boolean vitimaExiste = repositorioVitima.findByCpf(cpfVitima).isPresent();
        if (!vitimaExiste) {
            throw new ExcecaoRecursoNaoEncontrado("Vítima com CPF " + cpfVitima + " não encontrada.");
        }

        Specification<Fonar> especificacao = (root, query, criteriaBuilder) -> {
            List<Predicate> predicados = new ArrayList<>();
            predicados.add(criteriaBuilder.equal(root.get("cpfVitima"), cpfVitima));

            if (filtros != null && filtros.getTextoBusca() != null && !filtros.getTextoBusca().isEmpty()) {
                String padraoLike = "%" + filtros.getTextoBusca().toLowerCase() + "%";
                Predicate predicadoTextoBusca = criteriaBuilder.or(
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("localRegistro")), padraoLike),
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("grauDeRiscoCalculado")), padraoLike),
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("statusTriagem")), padraoLike),
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("encaminhamentos")), padraoLike)
                );
                predicados.add(predicadoTextoBusca);
            }

            return criteriaBuilder.and(predicados.toArray(new Predicate[0]));
        };

        Sort ordenacao = Sort.unsorted();
        if (filtros != null && filtros.getOrdenarPor() != null && !filtros.getOrdenarPor().isEmpty()) {
            Sort.Direction direcao = "DESC".equalsIgnoreCase(filtros.getDirecao()) ? Sort.Direction.DESC : Sort.Direction.ASC;
            ordenacao = Sort.by(direcao, filtros.getOrdenarPor());
        } else {
            ordenacao = Sort.by(Sort.Direction.DESC, "dataRegistro");
        }

        List<Fonar> fonars = repositorioFonar.findAll(especificacao, ordenacao);

        return fonars.stream()
                .map(DTOHistoricoFonar::new)
                .collect(Collectors.toList());
    }

    public DTOSaidaFonar obterDetalhesFonarVitima(UUID idFonar, String cpfVitima) {
        Fonar fonar = repositorioFonar.findByIdFonarAndCpfVitima(idFonar, cpfVitima)
                .orElseThrow(() -> new ExcecaoRecursoNaoEncontrado(
                        "FONAR não encontrado para o ID " + idFonar + " e CPF " + cpfVitima + "."
                ));
        return FonarMapper.toResponseDTO(fonar);
    }

    public Delegacia buscarDelegaciaPorId(Long idDelegacia) {
        return repositorioDelegacia.findById(idDelegacia)
                .orElseThrow(() -> new ExcecaoRecursoNaoEncontrado("Delegacia com ID " + idDelegacia + " não encontrada."
                ));
    }

    public Usuario buscarUsuarioPorId(Long idUsuario) {
        return repositorioUsuario.findById(idUsuario)
                .orElseThrow(() -> new ExcecaoRecursoNaoEncontrado("Usuário com ID " + idUsuario + " não encontrado."
                ));
    }
}
