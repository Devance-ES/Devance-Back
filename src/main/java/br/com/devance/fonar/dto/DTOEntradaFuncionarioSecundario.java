package br.com.devance.fonar.dto;

import br.com.devance.fonar.enums.Cargo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate; // Data de nascimento
import java.time.LocalDateTime; // Data de nascimento se herdado de Usuario

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DTOEntradaFuncionarioSecundario {
    @NotBlank(message = "O nome do funcionário é obrigatório.")
    private String nome;

    @NotBlank(message = "O CPF do funcionário é obrigatório.")
    @Size(min = 11, max = 11, message = "O CPF deve ter 11 caracteres.")
    private String cpf;

    @NotBlank(message = "O email do funcionário é obrigatório.")
    private String email;

    @NotBlank(message = "A senha do funcionário é obrigatória.")
    private String senha; // Lembre-se de hashear no Service

    @NotNull(message = "A data de nascimento do funcionário é obrigatória.")
    private LocalDateTime dataNascimento; // Ou LocalDate, conforme seu modelo Usuario/FuncionarioSecundario

    @NotNull(message = "O cargo do funcionário é obrigatório.")
    private Cargo cargo;

    // idDelegacia não vem aqui, pois é passado como parâmetro do endpoint ou do contexto de segurança
}