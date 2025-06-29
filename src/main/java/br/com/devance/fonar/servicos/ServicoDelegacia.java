package br.com.devance.fonar.servicos;

import br.com.devance.fonar.enums.StatusDelegacia;
import br.com.devance.fonar.excecoes.ExcecaoRecursoNaoEncontrado;
import br.com.devance.fonar.models.Delegacia;
import br.com.devance.fonar.models.Delegado;
import br.com.devance.fonar.models.FuncionarioSecundario;
import br.com.devance.fonar.models.SuperAdministrador;


// DTOs de entrada para Delegacia e Funcionário
import br.com.devance.fonar.dto.DTOEntradaDelegacia;
import br.com.devance.fonar.dto.DTOAtualizacaoDelegacia;
import br.com.devance.fonar.dto.DTOEntradaFuncionarioSecundario;

import br.com.devance.fonar.repositorios.RepositorioDelegacia;
import br.com.devance.fonar.repositorios.RepositorioDelegado;
import br.com.devance.fonar.repositorios.RepositorioFuncionarioSecundario;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServicoDelegacia {

    @Autowired
    private RepositorioDelegacia repositorioDelegacia;

    @Autowired
    private br.com.devance.fonar.repositorios.RepositorioSuperAdministrador repositorioSuperAdministrador;

    @Autowired
    private RepositorioDelegado repositorioDelegado;

    @Autowired
    private RepositorioFuncionarioSecundario repositorioFuncionarioSecundario;

    // @Autowired private ServicoAuditoria servicoAuditoria; // Temporariamente fora de uso
    @Autowired
    private ServicoGerenciamentoTarefas servicoGerenciamentoTarefas;


    // UC-005: Cadastrar nova delegacia (Super Administrador)
    @Transactional
    public Delegacia cadastrarDelegacia(DTOEntradaDelegacia dtoEntrada, Long idSuperAdminExecutor) {
        if (repositorioDelegacia.existsByCnpj(dtoEntrada.getCnpj())) {
            throw new IllegalArgumentException("Já existe uma delegacia cadastrada com este CNPJ.");
        }

        SuperAdministrador superAdmin = (SuperAdministrador) repositorioSuperAdministrador.findById(idSuperAdminExecutor)
                .orElseThrow(() -> new ExcecaoRecursoNaoEncontrado("Super Administrador executor não encontrado."));

        Delegado delegadoResponsavel = null;
        if (dtoEntrada.getIdResponsavel() != null) {
            delegadoResponsavel = (Delegado) repositorioDelegado.findById(dtoEntrada.getIdResponsavel())
                    .orElseThrow(() -> new ExcecaoRecursoNaoEncontrado("Delegado responsável não encontrado."));
        }

        Delegacia delegacia = new Delegacia();
        BeanUtils.copyProperties(dtoEntrada, delegacia);
        delegacia.setStatus(StatusDelegacia.PENDENTE_VALIDACAO);
        delegacia.setSuperAdministradorGerenciador(superAdmin);

        Delegacia delegaciaSalva = repositorioDelegacia.save(delegacia);

        return delegaciaSalva;
    }

    // UC-006: Validar cadastro de nova delegacia (Super Administrador)
    @Transactional
    public Delegacia validarDelegacia(Long idDelegacia, boolean aprovar, Long idSuperAdminExecutor) {
        Delegacia delegacia = repositorioDelegacia.findById(idDelegacia)
                .orElseThrow(() -> new ExcecaoRecursoNaoEncontrado("Delegacia não encontrada."));

        if (aprovar) {
            delegacia.setStatus(StatusDelegacia.ATIVA);
            // servicoAuditoria.registrarEvento("DELEGACIA_VALIDADA", idDelegacia.toString(), "Delegacia aprovada por Super Admin: " + idSuperAdminExecutor);
        } else {
            delegacia.setStatus(StatusDelegacia.REJEITADA);
            // servicoAuditoria.registrarEvento("DELEGACIA_REJEITADA", idDelegacia.toString(), "Delegacia rejeitada por Super Admin: " + idSuperAdminExecutor);
        }
        return repositorioDelegacia.save(delegacia);
    }

    // UC-007: Selecionar responsável por uma delegacia (Super Administrador)
    @Transactional
    public Delegacia alterarResponsavelDelegacia(Long idDelegacia, Long idNovoResponsavelDelegado, Long idSuperAdminExecutor) {
        Delegacia delegacia = repositorioDelegacia.findById(idDelegacia)
                .orElseThrow(() -> new ExcecaoRecursoNaoEncontrado("Delegacia não encontrada."));

        Delegado novoResponsavel = (Delegado) repositorioDelegado.findById(idNovoResponsavelDelegado)
                .orElseThrow(() -> new ExcecaoRecursoNaoEncontrado("Novo delegado responsável não encontrado."));


        return repositorioDelegacia.save(delegacia);
    }

    // UC-008: Alterar dados cadastrais de uma delegacia (Super Administrador)
    @Transactional
    public Delegacia alterarDadosDelegacia(Long idDelegacia, DTOAtualizacaoDelegacia dtoAtualizacao, Long idSuperAdminExecutor) {
        Delegacia delegacia = repositorioDelegacia.findById(idDelegacia)
                .orElseThrow(() -> new ExcecaoRecursoNaoEncontrado("Delegacia não encontrada."));

        BeanUtils.copyProperties(dtoAtualizacao, delegacia, "id", "cnpj", "superAdministradorGerenciador"); // Evitar alterar PK, CNPJ e o SA gerenciador

        Delegacia delegaciaAtualizada = repositorioDelegacia.save(delegacia);
        // servicoAuditoria.registrarEvento("DELEGACIA_DADOS_ALTERADOS", idDelegacia.toString(), "Dados da Delegacia alterados por Super Admin: " + idSuperAdminExecutor);

        return delegaciaAtualizada;
    }

    // UC-009: Desativar uma delegacia (Super Administrador)
    @Transactional
    public Delegacia desativarDelegacia(Long idDelegacia, Long idSuperAdminExecutor) {
        Delegacia delegacia = repositorioDelegacia.findById(idDelegacia)
                .orElseThrow(() -> new ExcecaoRecursoNaoEncontrado("Delegacia não encontrada."));

        if (delegacia.getStatus() == StatusDelegacia.INATIVA) {
            throw new IllegalArgumentException("Delegacia já está inativa.");
        }

        delegacia.setStatus(StatusDelegacia.INATIVA);
        Delegacia delegaciaDesativada = repositorioDelegacia.save(delegacia);
        // servicoAuditoria.registrarEvento("DELEGACIA_DESATIVADA", idDelegacia.toString(), "Delegacia desativada por Super Admin: " + idSuperAdminExecutor);

        return delegaciaDesativada;
    }

    // UC-010: Acessar um resumo de uma delegacia (Super Administrador)
    public List<Delegacia> obterTodasDelegaciasAtivasOuResumo() { // Removido idSuperAdminExecutor, pois é uma lista geral
        return repositorioDelegacia.findByStatus(StatusDelegacia.ATIVA); // Retorna todas ativas
    }

    // UC-012: Cadastrar funcionários secundários (Delegado)
    @Transactional
    public FuncionarioSecundario cadastrarFuncionarioSecundario(DTOEntradaFuncionarioSecundario dtoEntradaFuncionario, Long idDelegaciaExecutor, Long idDelegadoExecutor) {
        Delegacia delegacia = repositorioDelegacia.findById(idDelegaciaExecutor)
                .orElseThrow(() -> new ExcecaoRecursoNaoEncontrado("Delegacia não encontrada."));

        if (repositorioFuncionarioSecundario.existsByCpf(dtoEntradaFuncionario.getCpf())) {
            throw new IllegalArgumentException("Já existe um funcionário secundário com este CPF.");
        }

        FuncionarioSecundario funcionario = new FuncionarioSecundario();
        BeanUtils.copyProperties(dtoEntradaFuncionario, funcionario);
        funcionario.setDelegacia(delegacia); // Associa o funcionário à delegacia
        // funcionario.setSenhaHash(passwordEncoder.encode(dtoEntradaFuncionario.getSenha())); // A senha deve ser hasheada
        // funcionario.setPerfil(PerfilUsuario.FUNCIONARIO_SECUNDARIO); // Definir o perfil

        FuncionarioSecundario funcionarioSalvo = repositorioFuncionarioSecundario.save(funcionario);
        // servicoAuditoria.registrarEvento("FUNCIONARIO_SECUNDARIO_CADASTRADO", funcionarioSalvo.getId().toString(), "Funcionário secundário cadastrado por Delegado: " + idDelegadoExecutor + " na Delegacia: " + idDelegaciaExecutor);

        return funcionarioSalvo;
    }

    // UC-028: Remover um colaborador de uma delegacia (Delegado)
    @Transactional
    public void removerFuncionarioSecundario(Long idDelegaciaExecutor, Long idFuncionarioParaRemover, Long idDelegadoExecutor) {
        Delegacia delegacia = repositorioDelegacia.findById(idDelegaciaExecutor)
                .orElseThrow(() -> new ExcecaoRecursoNaoEncontrado("Delegacia não encontrada."));

        FuncionarioSecundario funcionario = repositorioFuncionarioSecundario.findById(idFuncionarioParaRemover)
                .orElseThrow(() -> new ExcecaoRecursoNaoEncontrado("Funcionário não encontrado."));

        if (!funcionario.getDelegacia().getId().equals(delegacia.getId())) {
            throw new IllegalArgumentException("Funcionário não pertence à delegacia especificada.");
        }

        repositorioFuncionarioSecundario.save(funcionario);

        servicoGerenciamentoTarefas.desvincularTarefasDoColaborador(idFuncionarioParaRemover, idDelegadoExecutor);

        // servicoAuditoria.registrarEvento("FUNCIONARIO_SECUNDARIO_REMOVIDO", idFuncionarioParaRemover.toString(), "Funcionário secundário inativado por Delegado: " + idDelegadoExecutor + " na Delegacia: " + idDelegaciaExecutor);
    }
}