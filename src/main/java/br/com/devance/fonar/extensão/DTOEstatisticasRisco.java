package br.com.devance.fonar.extensão;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DTOEstatisticasRisco {
    private long totalCasos;
    private long casosBaixo;
    private long casosMedio;
    private long casosAlto;
}