package br.com.devance.fonar.dto;

import br.com.devance.fonar.enums.TipoAgressaoQ2;
import br.com.devance.fonar.enums.TipoAgressaoQ3;
import br.com.devance.fonar.enums.TipoAmeaca;
import br.com.devance.fonar.enums.TipoComportamento;
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
public class DTOHistoricoViolenciaFonar {
    @NotEmpty(message = "A lista de ameaças não pode ser vazia.") // Se deve ter ao menos um item
    @NotNull(message = "As ameaças são obrigatórias.") // Se o Set não pode ser null
    private Set<TipoAmeaca> ameacas;

    @NotEmpty(message = "A lista de agressões físicas Q2 não pode ser vazia.")
    @NotNull(message = "As agressões físicas Q2 são obrigatórias.")
    private Set<TipoAgressaoQ2> agressoesFisicasQ2;

    @NotEmpty(message = "A lista de agressões físicas Q3 não pode ser vazia.")
    @NotNull(message = "As agressões físicas Q3 são obrigatórias.")
    private Set<TipoAgressaoQ3> agressoesFisicasQ3;

    @NotNull(message = "A informação sobre obrigar sexo é obrigatória.")
    private Boolean obrigouSexo;

    @NotEmpty(message = "A lista de comportamentos não pode ser vazia.")
    @NotNull(message = "Os comportamentos do agressor são obrigatórios.")
    private Set<TipoComportamento> comportamentos;

    @NotNull(message = "A informação sobre registro de BO anterior é obrigatória.")
    private Boolean jaRegistrouBOAntes;

    @NotNull(message = "A informação sobre agressões frequentes recentemente é obrigatória.")
    private Boolean frequentesRecentemente;
}