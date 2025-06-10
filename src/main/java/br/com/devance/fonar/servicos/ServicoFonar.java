package br.com.devance.fonar.servicos;

import br.com.devance.fonar.excecoes.ExcecaoRecursoNaoEncontrado;
import br.com.devance.fonar.models.Fonar;
import br.com.devance.fonar.models.DTOHistoricoFonar;
import br.com.devance.fonar.models.DTOFiltroFonar;
import br.com.devance.fonar.repositorios.RepositorioFonar;
import br.com.devance.fonar.repositorios.RepositorioVitima;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

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

    public List<DTOHistoricoFonar> obterHistoricoFonarVitima(String cpfVitima, DTOFiltroFonar filtros) {
        boolean vitimaExiste = repositorioVitima.findByCpf(cpfVitima).isPresent();
        if (!vitimaExiste)
        {
            throw new ExcecaoRecursoNaoEncontrado("Vítima com CPF " + cpfVitima + " não encontrada.");        }

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

    public Fonar obterDetalhesFonarVitima(UUID idFonar, String cpfVitima) {
        return repositorioFonar.findByIdFonarAndCpfVitima(idFonar, cpfVitima)
                .orElseThrow(() -> new ExcecaoRecursoNaoEncontrado(
                        "FONAR não encontrado para o ID " + idFonar + " e CPF " + cpfVitima + "."
                ));
    }

}