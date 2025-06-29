package br.com.devance.fonar.dto;

import br.com.devance.fonar.enums.TipoPreenchimentoProfissional;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DTOPreenchimentoProfissionalFonar {

    @NotNull(message = "A informação sobre o tipo de preenchimento profissional é obrigatória.")
    private TipoPreenchimentoProfissional tipoPreenchimento;
}
