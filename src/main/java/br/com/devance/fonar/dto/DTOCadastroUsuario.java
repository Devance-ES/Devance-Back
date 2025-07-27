package br.com.devance.fonar.dto;

import br.com.devance.fonar.enums.PerfilUsuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DTOCadastroUsuario {

    @NotBlank(message = "O nome é obrigatório.")
    private String nome;

    @NotBlank(message = "O CPF é obrigatório.")
    @Size(min = 11, max = 11, message = "O CPF deve ter 11 caracteres.")
    private String cpf;

    @NotBlank(message = "O e-mail é obrigatório.")
    @Email(message = "Formato de e-mail inválido.")
    private String email;

    @NotBlank(message = "A senha é obrigatória.")
    @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres.")
    private String senha; // Senha em texto plano

    @NotNull(message = "A data de nascimento é obrigatória.")
    private LocalDateTime dataNascimento;

    @NotNull(message = "O perfil do usuário é obrigatório.")
    private PerfilUsuario perfil;
}