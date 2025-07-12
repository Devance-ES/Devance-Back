package br.com.devance.fonar.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DTOAtribuicaoResponsavelDelegacia {
    @NotNull(message = "O ID do novo responsável é obrigatório.")
    private Long idNovoResponsavel;
}