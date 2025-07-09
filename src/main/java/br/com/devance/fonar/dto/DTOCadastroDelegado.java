package br.com.devance.fonar.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DTOCadastroDelegado {
    @NotBlank(message = "O nome do delegado é obrigatório.")
    private String nome;

    @NotBlank(message = "O CPF do delegado é obrigatório.")
    @Size(min = 11, max = 11, message = "O CPF deve ter 11 caracteres.")
    private String cpf;

    @NotBlank(message = "O e-mail do delegado é obrigatório.")
    private String email;

    @NotBlank(message = "A senha do delegado é obrigatória.")
    private String senha; // Em texto plano, será hasheada no serviço

    @NotNull(message = "A data de nascimento do delegado é obrigatória.")
    private LocalDateTime dataNascimento; // Conforme o Usuario base

    @NotNull(message = "A data de cadastro do delegado é obrigatória.")
    private LocalDate dataCadastro; // Data que se tornou delegado

    @NotNull(message = "O ID da delegacia de associação é obrigatório.")
    private Long idDelegacia; // ID da Delegacia a qual este Delegado será associado
}