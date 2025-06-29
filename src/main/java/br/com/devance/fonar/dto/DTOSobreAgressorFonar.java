package br.com.devance.fonar.dto;

import br.com.devance.fonar.enums.DoencaMental;
import br.com.devance.fonar.enums.EspecificacaoAmeaca;
import br.com.devance.fonar.enums.RespostasSimNaoNaoSei;
import br.com.devance.fonar.enums.UsoAbusivo;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DTOSobreAgressorFonar {

    @NotNull(message = "O uso abusivo deve ser informado.")
    private UsoAbusivo usoAbusivo;

    @NotNull(message = "A informação sobre doença mental deve ser informada.")
    private DoencaMental doencaMental;

    @NotNull(message = "Informe se o agressor já descumpriu medida protetiva.")
    private Boolean descumpriuMedidaProtetiva;

    @NotNull(message = "Informe se o agressor já tentou ou falou em suicídio.")
    private Boolean tentouSuicidio;

    @NotNull(message = "Informe se o agressor tem dificuldades financeiras.")
    private RespostasSimNaoNaoSei dificuldadesFinancieras;

    @NotNull(message = "Informe se o agressor tem acesso a armas de fogo.")
    private RespostasSimNaoNaoSei acessoArmasFogo;

    @NotNull(message = "Informe se o agressor já ameaçou ou agrediu outras pessoas.")
    private Boolean ameacouOuAgrediu;

    @NotEmpty(message = "As especificações da ameaça/agressão devem ser informadas.") // Se deve ter ao menos um item
    @NotNull(message = "As especificações da ameaça/agressão não podem ser nulas.") // Se o Set não pode ser null
    private Set<EspecificacaoAmeaca> especificacoesAmeaca; // Use Set para listas de enums aqui
}
