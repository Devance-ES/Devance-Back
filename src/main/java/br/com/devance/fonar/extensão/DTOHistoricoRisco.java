package br.com.devance.fonar.extensão;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DTOHistoricoRisco {
    private Long id;
    private String cpfAgressor;
    private LocalDateTime dataAvaliacao;
    private String statusRisco;
    private Integer pontuacaoRisco;
}