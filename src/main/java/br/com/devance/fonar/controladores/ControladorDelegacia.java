package br.com.devance.fonar.controladores;

import br.com.devance.fonar.models.TarefaTriagem;
import br.com.devance.fonar.servicos.ServicoGerenciamentoTarefas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/delegacias")
public class ControladorDelegacia {

    @Autowired
    private ServicoGerenciamentoTarefas servicoGerenciamentoTarefas;

    @GetMapping("/{idDelegacia}/kanban")
    public ResponseEntity<Map<String, List<TarefaTriagem>>> obterKanbanDelegacia(
            @PathVariable Long idDelegacia) {


        Map<String, List<TarefaTriagem>> kanbanData = servicoGerenciamentoTarefas.obterDadosKanbanDelegacia(idDelegacia);
        return ResponseEntity.ok(kanbanData);
    }
}