package br.com.devance.fonar.controladores;

import br.com.devance.fonar.models.Fonar;
import br.com.devance.fonar.models.DTOHistoricoFonar;
import br.com.devance.fonar.models.DTOFiltroFonar;
import br.com.devance.fonar.servicos.ServicoFonar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/fonar")
public class ControladorFonar {

    @Autowired
    private ServicoFonar servicoFonar;

    @GetMapping("/historico/vitima/{cpf}")
    public ResponseEntity<List<DTOHistoricoFonar>> obterHistoricoFonarVitima(
            @PathVariable String cpf,
            @ModelAttribute DTOFiltroFonar filtros) {

        List<DTOHistoricoFonar> historico = servicoFonar.obterHistoricoFonarVitima(cpf, filtros);
        return ResponseEntity.ok(historico);
    }

    @GetMapping("/historico/vitima/{cpf}/detalhes/{idFonar}")
    public ResponseEntity<Fonar> obterDetalhesFonarVitima(
            @PathVariable String cpf,
            @PathVariable UUID idFonar) {


        Fonar detalhesFonar = servicoFonar.obterDetalhesFonarVitima(idFonar, cpf);
        return ResponseEntity.ok(detalhesFonar);
    }

    //mostrar todos os fonars
    @GetMapping("/todos")
    public String mostrarFonar(){
        return "fonar mostrado";
    }
    //criar fonar
    @PostMapping("/criar")
    public String adcionarFonar(){
        return "fonar criado";
    }

    //deletar fonar
    @DeleteMapping("/deletar")
    public String deletarFonar(){
        return "fonar deletado";
    }
}