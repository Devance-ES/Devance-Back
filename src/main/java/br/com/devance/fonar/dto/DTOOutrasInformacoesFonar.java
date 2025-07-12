package br.com.devance.fonar.dto;

import br.com.devance.fonar.enums.RespostasSimNaoNaoSei;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DTOOutrasInformacoesFonar {

    @NotNull(message = "A informação sobre morar em local de risco é obrigatória.")
    private RespostasSimNaoNaoSei moraEmLocalDeRisco;

    @NotNull(message = "A informação sobre dependência financeira do agressor é obrigatória.")
    private Boolean dependenciaFinanceiraAgressor;

    @NotNull(message = "A informação sobre necessitar de abrigo temporário é obrigatória.")
    private Boolean querAbrigoTemporario;
}
