package br.com.devance.fonar.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DTOAtualizacaoDelegado {
    private String nome;
    private String email;
    private String numeroContato; // Se aplicável, adicione este campo no DTO e na entidade Usuario se for geral
    private String novaSenha; // Para alteração de senha


    private Long idNovaDelegacia;
}