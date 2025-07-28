// src/main/java/br/com/devance/fonar/dto/DTOAtualizacaoUsuario.java
package br.com.devance.fonar.dto;

import br.com.devance.fonar.enums.PerfilUsuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DTOAtualizacaoUsuario {
    // Campos que podem ser atualizados. CPF geralmente não é alterável.
    private String nome;

    @Email(message = "Formato de e-mail inválido.")
    private String email;

    @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres.")
    private String senha;

    private PerfilUsuario perfil; // Permite alterar o perfil (requer SUPER_ADMIN)
    private Boolean ativo; // Permite ativar/desativar o usuário
    private Integer tentativasFalhas; // Permite resetar ou ajustar tentativas de falha
    private LocalDateTime dataBloqueio; // Permite bloquear/desbloquear (definir data ou null)
}
