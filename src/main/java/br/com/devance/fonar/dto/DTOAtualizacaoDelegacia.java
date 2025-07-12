package br.com.devance.fonar.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DTOAtualizacaoDelegacia {

    @NotBlank(message = "O nome da delegacia é obrigatório para atualização.")
    private String nome;

    @NotNull(message = "O tipo da delegacia é obrigatório para atualização.")
    private String tipo;

    @NotBlank(message = "O endereço da delegacia é obrigatório para atualização.")
    private String endereco;

    @NotBlank(message = "As informações de contato são obrigatórias para atualização.")
    private String informacaoContato;

    private String novaSenha;
}