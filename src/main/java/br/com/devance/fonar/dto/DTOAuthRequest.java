package br.com.devance.fonar.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DTOAuthRequest { // Classe renomeada para DTOAuthRequest
    @NotBlank(message = "O CPF é obrigatório para login.")
    private String cpf; // Nome de usuário, que pode ser CPF ou Email
    @NotBlank(message = "A senha é obrigatória para login.")
    private String senha;
}