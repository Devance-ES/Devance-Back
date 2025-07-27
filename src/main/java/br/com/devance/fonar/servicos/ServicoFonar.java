package br.com.devance.fonar.servicos;

import br.com.devance.fonar.dto.*;
import br.com.devance.fonar.enums.Status;
import br.com.devance.fonar.excecoes.ExcecaoRecursoNaoEncontrado;
import br.com.devance.fonar.mappers.FonarMapper;
import br.com.devance.fonar.models.Delegacia;
import br.com.devance.fonar.models.Fonar;
import br.com.devance.fonar.models.Usuario;
import br.com.devance.fonar.models.Vitima;
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
import java.time.LocalDateTime;
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

//    @Transactional
//    public void salvarDadosAleatorios() {
//        // Criação de dados aleatórios para testes usando construtores válidos, evitando
//        // duplicidade
//        // 1. Criar e salvar uma vítima fictícia se não existir
//        var vitimaOpt = repositorioVitima.findByCpf("00011122233");
//        var vitima = vitimaOpt.orElseGet(() -> {
//            var v = new br.com.devance.fonar.models.Vitima(
//                    "00011122233",
//                    "Vitima Teste",
//                    java.time.LocalDateTime.of(1990, 1, 1, 0, 0),
//                    "11999999999",
//                    "vitima@teste.com");
//            return repositorioVitima.save(v);
//        });
//
//        // 2. Criar e salvar uma delegacia fictícia se não existir
//        var delegaciaOpt = repositorioDelegacia.findAll().stream()
//                .filter(d -> "12345678000199".equals(d.getCnpj()))
//                .findFirst();
//        var delegacia = delegaciaOpt.orElseGet(() -> {
//            var d = new br.com.devance.fonar.models.Delegacia(
//                    "Delegacia Teste",
//                    "12345678000199",
//                    "Rua Exemplo, 123",
//                    "senha123",
//                    "11999999999",
//                    new java.util.ArrayList<>(),
//                    null,
//                    null);
//            return repositorioDelegacia.save(d);
//        });
//
//        // 3. Criar e salvar um Delegado fictício se não existir
//        var usuarioOpt = repositorioUsuario.findAll().stream()
//                .filter(u -> u.getCpf() != null && u.getCpf().equals("12345678900"))
//                .findFirst();
//        var usuario = usuarioOpt.orElseGet(() -> repositorioUsuario.save(
//                new br.com.devance.fonar.models.Delegado(
//                        "Delegado Teste",
//                        "12345678900",
//                        "delegado@teste.com",
//                        "senha123",
//                        java.time.LocalDateTime.of(1985, 5, 10, 0, 0),
//                        java.time.LocalDateTime.now(),
//                        delegacia,
//                        "11988887777",
//                        true,
//                        br.com.devance.fonar.enums.PerfilUsuario.DELEGADO)));
//
//        // 4. Criar e salvar um Fonar fictício se não existir
//        var fonarOpt = repositorioFonar.findAll().stream()
//                .filter(f -> f.getCpfVitima() != null && f.getCpfVitima().equals("00011122233"))
//                .findFirst();
//        fonarOpt.orElseGet(() -> {
//            var fonar = new br.com.devance.fonar.models.Fonar();
//            fonar.setCpfVitima(vitima.getCpf());
//            fonar.setDataRegistro(java.time.LocalDate.now());
//            fonar.setStatusTriagem(br.com.devance.fonar.enums.Status.CRIADA);
//            fonar.setDelegacia(delegacia);
//            fonar.setResponsavel(usuario.getCpf());
//            fonar.setGrauDeRiscoCalculado("BAIXO");
//            return repositorioFonar.save(fonar);
//        });
//    }

    @Transactional
    public DTOSaidaFonar registrarFonarOnline(DTOEntradaFonar dtoEntradaFonar) {// Lógica CORRIGIDA: Criar ou reutilizar a vítima
        Vitima vitimaExistente = repositorioVitima.findByCpf(dtoEntradaFonar.getCpfVitima()).orElse(null);

        if (vitimaExistente == null) {
            LocalDateTime dataNascimentoVitima = null;
            dataNascimentoVitima = LocalDate.now()
                    .minusYears(dtoEntradaFonar.getIdentificacaoPartes().getIdadeVitima())
                    .atStartOfDay();

            Vitima novaVitima = new Vitima(
                    dtoEntradaFonar.getCpfVitima(), dtoEntradaFonar.getIdentificacaoPartes().getNomeVitima(),
                    dataNascimentoVitima, null, null
            );
            vitimaExistente = repositorioVitima.save(novaVitima);
        }

        Fonar fonar = FonarMapper.toEntity(dtoEntradaFonar);

        // Ajustes específicos do fluxo online (sem delegacia e responsável)
        fonar.setStatusTriagem(Status.CRIADA);
        fonar.setDataRegistro(LocalDate.now());
        // Se o FONAR precisa de uma Delegacia padrão para registro público, defina aqui.
        // fonar.setDelegacia(delegaciaPadrao);
        // fonar.setResponsavel(null);

        Fonar fonarSalvo = repositorioFonar.save(fonar);

        // Retorna DTO de resposta
        return FonarMapper.toResponseDTO(fonarSalvo);
    }

    @Transactional
    public DTOSaidaFonar registrarNovoFonar(DTOEntradaFonar dtoEntradaFonar, Delegacia delegacia, Usuario usuario) {
        Vitima vitimaExistente = repositorioVitima.findByCpf(dtoEntradaFonar.getCpfVitima()).orElse(null);

        if (vitimaExistente == null) {
            LocalDateTime dataNascimentoVitima = null;
            dataNascimentoVitima = LocalDate.now()
                    .minusYears(dtoEntradaFonar.getIdentificacaoPartes().getIdadeVitima())
                    .atStartOfDay();

            Vitima novaVitima = new Vitima(
                    dtoEntradaFonar.getCpfVitima(), dtoEntradaFonar.getIdentificacaoPartes().getNomeVitima(),
                    dataNascimentoVitima, null, null
            );
            vitimaExistente = repositorioVitima.save(novaVitima);
        }

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
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("encaminhamentos")), padraoLike));
                predicados.add(predicadoTextoBusca);
            }

            return criteriaBuilder.and(predicados.toArray(new Predicate[0]));
        };

        Sort ordenacao = Sort.unsorted();
        if (filtros != null && filtros.getOrdenarPor() != null && !filtros.getOrdenarPor().isEmpty()) {
            Sort.Direction direcao = "DESC".equalsIgnoreCase(filtros.getDirecao()) ? Sort.Direction.DESC
                    : Sort.Direction.ASC;
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
                        "FONAR não encontrado para o ID " + idFonar + " e CPF " + cpfVitima + "."));
        return FonarMapper.toResponseDTO(fonar);
    }

    public Delegacia buscarDelegaciaPorId(Long idDelegacia) {
        return repositorioDelegacia.findById(idDelegacia)
                .orElseThrow(
                        () -> new ExcecaoRecursoNaoEncontrado("Delegacia com ID " + idDelegacia + " não encontrada."));
    }

    public Usuario buscarUsuarioPorId(Long idUsuario) {
        return repositorioUsuario.findById(idUsuario)
                .orElseThrow(() -> new ExcecaoRecursoNaoEncontrado("Usuário com ID " + idUsuario + " não encontrado."));
    }
}
