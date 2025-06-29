package br.com.devance.fonar.dto;

import br.com.devance.fonar.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DTOSaidaFonar {

    private UUID idFonar;
    private String cpfVitima;
    private String nomeDelegacia; // Virá de 'delegacia.getNome()'
    private LocalDate dataRegistro;
    private String responsavel;
    private String grauDeRiscoCalculado;
    private Status statusTriagem;

}
