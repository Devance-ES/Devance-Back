package br.com.devance.fonar.controladores;

import br.com.devance.fonar.dto.DTOAtribuicaoResponsavelDelegacia;
import br.com.devance.fonar.dto.DTOAtualizacaoDelegacia;
import br.com.devance.fonar.dto.DTOEntradaDelegacia;
import br.com.devance.fonar.dto.DTOEntradaFuncionarioSecundario;
import br.com.devance.fonar.models.Delegacia;
import br.com.devance.fonar.models.FuncionarioSecundario;
import br.com.devance.fonar.models.TarefaTriagem;
import br.com.devance.fonar.servicos.ServicoDelegacia;
import br.com.devance.fonar.servicos.ServicoGerenciamentoTarefas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/delegacias")
public class ControladorDelegacia {

    @Autowired
    private ServicoGerenciamentoTarefas servicoGerenciamentoTarefas;

    @Autowired
    private ServicoDelegacia servicoDelegacia;

    @GetMapping("/{idDelegacia}/kanban")
    public ResponseEntity<Map<String, List<TarefaTriagem>>> obterKanbanDelegacia(
            @PathVariable Long idDelegacia) {


        Map<String, List<TarefaTriagem>> kanbanData = servicoGerenciamentoTarefas.obterDadosKanbanDelegacia(idDelegacia);
        return ResponseEntity.ok(kanbanData);
    }

    // UC-005: Cadastrar nova delegacia
    @PostMapping ("/delegacia")// POST /api/v1/delegacias
    public ResponseEntity<Delegacia> cadastrarNovaDelegacia(
            @RequestBody DTOEntradaDelegacia dtoEntrada,
            // O ID do executor viria do token JWT do usuário autenticado (Super Administrador)
            @RequestHeader(name = "X-User-Id", required = false) Long idSuperAdminExecutor) {

        // Simulação do ID do Super Admin para teste se não há autenticação real
        idSuperAdminExecutor = (idSuperAdminExecutor != null) ? idSuperAdminExecutor : 1L; // Exemplo de ID padrão para SA

        Delegacia novaDelegacia = servicoDelegacia.cadastrarDelegacia(dtoEntrada, idSuperAdminExecutor);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaDelegacia); // Retorna 201 Created
    }

    // UC-006: Validar cadastro de nova delegacia
    @PutMapping("/{idDelegacia}/validar") // PUT /api/v1/delegacias/{idDelegacia}/validar?aprovar=true
    public ResponseEntity<Delegacia> validarCadastroDelegacia(
            @PathVariable Long idDelegacia,
            @RequestParam boolean aprovar, // Query param: ?aprovar=true ou ?aprovar=false
            @RequestHeader(name = "X-User-Id", required = false) Long idSuperAdminExecutor) {

        idSuperAdminExecutor = (idSuperAdminExecutor != null) ? idSuperAdminExecutor : 1L;

        Delegacia delegaciaValidada = servicoDelegacia.validarDelegacia(idDelegacia, aprovar, idSuperAdminExecutor);
        return ResponseEntity.ok(delegaciaValidada); // Retorna 200 OK
    }

    // UC-007: Selecionar responsável por uma delegacia
    @PutMapping("/{idDelegacia}/responsavel") // PUT /api/v1/delegacias/{idDelegacia}/responsavel
    public ResponseEntity<Delegacia> selecionarResponsavelDelegacia(
            @PathVariable Long idDelegacia,
            @RequestBody DTOAtribuicaoResponsavelDelegacia dtoAtribuicao, // DTO contendo o ID do novo responsável
            @RequestHeader(name = "X-User-Id", required = false) Long idSuperAdminExecutor) {

        idSuperAdminExecutor = (idSuperAdminExecutor != null) ? idSuperAdminExecutor : 1L;

        Delegacia delegaciaAtualizada = servicoDelegacia.alterarResponsavelDelegacia(
                idDelegacia, dtoAtribuicao.getIdNovoResponsavel(), idSuperAdminExecutor);
        return ResponseEntity.ok(delegaciaAtualizada); // Retorna 200 OK
    }

    // UC-008: Alterar dados cadastrais de uma delegacia
    @PutMapping("/{idDelegacia}/dados") // PUT /api/v1/delegacias/{idDelegacia}/dados
    public ResponseEntity<Delegacia> alterarDadosDelegacia(
            @PathVariable Long idDelegacia,
            @RequestBody DTOAtualizacaoDelegacia dtoAtualizacao, // DTO com os dados a serem atualizados
            @RequestHeader(name = "X-User-Id", required = false) Long idSuperAdminExecutor) {

        idSuperAdminExecutor = (idSuperAdminExecutor != null) ? idSuperAdminExecutor : 1L;

        Delegacia delegaciaAtualizada = servicoDelegacia.alterarDadosDelegacia(idDelegacia, dtoAtualizacao, idSuperAdminExecutor);
        return ResponseEntity.ok(delegaciaAtualizada); // Retorna 200 OK
    }

    // UC-009: Desativar uma delegacia
    @PutMapping("/{idDelegacia}/desativar") // PUT /api/v1/delegacias/{idDelegacia}/desativar
    public ResponseEntity<Delegacia> desativarDelegacia(
            @PathVariable Long idDelegacia,
            @RequestHeader(name = "X-User-Id", required = false) Long idSuperAdminExecutor) {

        idSuperAdminExecutor = (idSuperAdminExecutor != null) ? idSuperAdminExecutor : 1L;

        Delegacia delegaciaDesativada = servicoDelegacia.desativarDelegacia(idDelegacia, idSuperAdminExecutor);
        return ResponseEntity.ok(delegaciaDesativada); // Retorna 200 OK
    }

    // UC-010: Acessar um resumo de uma delegacia (lista de todas as delegacias ativas para SA)
    @GetMapping("/resumo") // GET /api/v1/delegacias/resumo
    public ResponseEntity<List<Delegacia>> obterResumoDelegacias() {
        // A autorização para este endpoint seria feita via Spring Security (ex: @PreAuthorize("hasRole('SUPER_ADMIN')"))
        List<Delegacia> resumoDelegacias = servicoDelegacia.obterTodasDelegaciasAtivasOuResumo();
        return ResponseEntity.ok(resumoDelegacias); // Retorna 200 OK
    }

    // --- Métodos de Delegados e Funcionários (Gestão interna da Delegacia) ---

    // UC-012: Cadastrar funcionários secundários
    @PostMapping("/{idDelegacia}/funcionarios") // POST /api/v1/delegacias/{idDelegacia}/funcionarios
    public ResponseEntity<FuncionarioSecundario> cadastrarFuncionarioSecundario(
            @PathVariable Long idDelegacia, // ID da delegacia que está cadastrando o funcionário
            @RequestBody DTOEntradaFuncionarioSecundario dtoEntradaFuncionario,
            @RequestHeader(name = "X-User-Id", required = false) Long idDelegadoExecutor) { // ID do Delegado logado

        // idDelegadoExecutor deve vir do contexto de segurança. idDelegacia do path.
        idDelegadoExecutor = (idDelegadoExecutor != null) ? idDelegadoExecutor : 101L; // Exemplo de ID padrão para Delegado

        FuncionarioSecundario novoFuncionario = servicoDelegacia.cadastrarFuncionarioSecundario(dtoEntradaFuncionario, idDelegacia, idDelegadoExecutor);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoFuncionario); // Retorna 201 Created
    }

    // UC-028: Remover um colaborador de uma delegacia (Delegado)
    @DeleteMapping("/{idDelegacia}/funcionarios/{idFuncionario}") // DELETE /api/v1/delegacias/{idDelegacia}/funcionarios/{idFuncionario}
    public ResponseEntity<Void> removerColaboradorDelegacia(
            @PathVariable Long idDelegacia,
            @PathVariable Long idFuncionario,
            @RequestHeader(name = "X-User-Id", required = false) Long idDelegadoExecutor) {

        idDelegadoExecutor = (idDelegadoExecutor != null) ? idDelegadoExecutor : 101L; // Exemplo de ID padrão

        servicoDelegacia.removerFuncionarioSecundario(idDelegacia, idFuncionario, idDelegadoExecutor);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content
    }
}