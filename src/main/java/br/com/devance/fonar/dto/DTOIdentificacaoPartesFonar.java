package br.com.devance.fonar.dto;

import br.com.devance.fonar.enums.Escolaridade;
import br.com.devance.fonar.enums.Nacionalidade;
import br.com.devance.fonar.enums.Vinculo;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DTOIdentificacaoPartesFonar {
    @NotBlank(message = "O nome da vítima é obrigatório.")
    private String nomeVitima;

    @Min(value = 0, message = "A idade da vítima não pode ser negativa.")
    private int idadeVitima;

    @NotNull(message = "A escolaridade da vítima é obrigatória.")
    private Escolaridade escolaridadeVitima;

    @NotNull(message = "A nacionalidade da vítima é obrigatória.")
    private Nacionalidade nacionalidadeVitima;

    @NotBlank(message = "O nome do agressor é obrigatório.") // Mesmo que CPF não seja, o nome pode ser mandatório
    private String nomeAgressor;

    @Min(value = 0, message = "A idade do agressor não pode ser negativa.")
    private int idadeAgressor;

    @NotNull(message = "A escolaridade do agressor é obrigatória.")
    private Escolaridade escolaridadeAgressor;

    @NotNull(message = "A nacionalidade do agressor é obrigatória.")
    private Nacionalidade nacionalidadeAgressor;

    @NotNull(message = "O vínculo entre as partes é obrigatório.")
    private Vinculo vinculoEntrePartes;

    @NotNull(message = "A data da ocorrência é obrigatória.")
    private LocalDate dataOcorrencia;
}

