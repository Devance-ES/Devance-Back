package br.com.devance.fonar.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DTOEntradaDelegacia {
    @NotBlank(message = "O nome da delegacia é obrigatório.")
    private String nome;

    @NotNull(message = "O tipo da delegacia é obrigatório.")
    private String tipo;

    @NotBlank(message = "O CNPJ da delegacia é obrigatório.")
    @Size(min = 14, max = 14, message = "O CNPJ deve ter 14 caracteres.")
    private String cnpj;

    @NotNull(message = "O ID do Delegado responsável é obrigatório.") // ID do Delegado que será responsável
    private Long idResponsavel;

    @NotBlank(message = "O endereço da delegacia é obrigatório.")
    private String endereco;

    @NotBlank(message = "As informações de contato são obrigatórias.")
    private String informacaoContato;

    @NotBlank(message = "A senha da delegacia é obrigatória.")
    private String senha; // Lembre-se de que no Service ela será hasheada
}