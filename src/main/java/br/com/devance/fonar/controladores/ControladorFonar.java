package br.com.devance.fonar.controladores;

import br.com.devance.fonar.dto.DTOEntradaFonar;
import br.com.devance.fonar.dto.DTOFiltroFonar;
import br.com.devance.fonar.dto.DTOHistoricoFonar;
import br.com.devance.fonar.models.Delegacia;
import br.com.devance.fonar.models.Fonar;
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

    // UC01, UC02, UC03: Acessar, Preencher, Revisar e Enviar o FONAR (Vítima)
    @PostMapping("/publico")
    public ResponseEntity<Fonar> registrarFonarPublico(@RequestBody DTOEntradaFonar dtoEntradaFonar) {
        Fonar fonarSalvo = servicoFonar.registrarFonarOnline(dtoEntradaFonar);
        return ResponseEntity.status(HttpStatus.CREATED).body(fonarSalvo); // Retorna 201 Created
    }

    // UC16: Registrar Novo FONAR (para Delegados e Funcionários)
    @PostMapping("/instituicao")
    public ResponseEntity<Fonar> registrarFonarInstituicao(
            @RequestBody DTOEntradaFonar dtoEntradaFonar,
            @RequestParam(name = "idDelegacia", required = false) Delegacia delegacia,
            @RequestParam(name = "idUsuarioResponsavel", required = false) Usuario usuarioResponsavel) {


        // Aqui você obteria os IDs reais do usuário logado e sua delegacia, por exemplo:
        // Long idDelegaciaAutenticada = ...; // Ex: SecurityContextHolder.getContext().getAuthentication().getPrincipal().getDelegacia().getId();
        // Long idUsuarioLogado = ...; // Ex: SecurityContextHolder.getContext().getAuthentication().getPrincipal().getId();


        Fonar fonarSalvo = servicoFonar.registrarNovoFonar(dtoEntradaFonar, delegacia, usuarioResponsavel);
        return ResponseEntity.status(HttpStatus.CREATED).body(fonarSalvo); // Retorna 201 Created
    }
}