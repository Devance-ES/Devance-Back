package br.com.devance.fonar.controladores;

import br.com.devance.fonar.dto.DTOEntradaFonar;
import br.com.devance.fonar.dto.DTOFiltroFonar;
import br.com.devance.fonar.dto.DTOHistoricoFonar;
import br.com.devance.fonar.dto.DTOSaidaFonar;
import br.com.devance.fonar.models.Delegacia;
import br.com.devance.fonar.models.Usuario;
import br.com.devance.fonar.servicos.ServicoFonar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/fonar")
public class ControladorFonar {

    @Autowired
    private ServicoFonar servicoFonar;

    @PostMapping("/test") // TODO: apagar depois
    public ResponseEntity<String> teste(@RequestBody String mensagem) {
        return ResponseEntity.ok(mensagem);
    }

    @GetMapping("/historico/vitima/{cpf}")
    public ResponseEntity<List<DTOHistoricoFonar>> obterHistoricoFonarVitima(
            @PathVariable String cpf,
            @ModelAttribute DTOFiltroFonar filtros) {

        List<DTOHistoricoFonar> historico = servicoFonar.obterHistoricoFonarVitima(cpf, filtros);
        return ResponseEntity.ok(historico);
    }

    @GetMapping("/historico/vitima/{cpf}/detalhes/{idFonar}")
    public ResponseEntity<DTOSaidaFonar> obterDetalhesFonarVitima(
            @PathVariable String cpf,
            @PathVariable UUID idFonar) {

        DTOSaidaFonar dto = servicoFonar.obterDetalhesFonarVitima(idFonar, cpf);
        return ResponseEntity.ok(dto);
    }

    // UC01, UC02, UC03: Acessar, Preencher, Revisar e Enviar o FONAR (Vítima)
    @PostMapping("/publico")
    public ResponseEntity<DTOSaidaFonar> registrarFonarPublico(@RequestBody DTOEntradaFonar dtoEntradaFonar) {
        DTOSaidaFonar dto = servicoFonar.registrarFonarOnline(dtoEntradaFonar);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    // UC16: Registrar Novo FONAR (para Delegados e Funcionários)
    @PostMapping("/instituicao")
    public ResponseEntity<DTOSaidaFonar> registrarFonarInstituicao(
            @RequestBody DTOEntradaFonar dtoEntradaFonar,
            @RequestParam(name = "idDelegacia") Long idDelegacia,
            @RequestParam(name = "idUsuarioResponsavel") Long idUsuarioResponsavel) {

        // Buscar entidades delegacia e usuario (você pode passar para o service fazer
        // isso)
        Delegacia delegacia = servicoFonar.buscarDelegaciaPorId(idDelegacia);
        Usuario usuarioResponsavel = servicoFonar.buscarUsuarioPorId(idUsuarioResponsavel);

        DTOSaidaFonar dto = servicoFonar.registrarNovoFonar(dtoEntradaFonar, delegacia, usuarioResponsavel);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }
}
