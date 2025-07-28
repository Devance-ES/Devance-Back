// src/main/java/br/com/devance/fonar/controladores/ControladorUsuario.java
package br.com.devance.fonar.controladores;

import br.com.devance.fonar.dto.DTOAtualizacaoUsuario;
import br.com.devance.fonar.dto.DTOSaidaUsuario; // Crie este DTO se ainda não tiver um para a saída de usuários
import br.com.devance.fonar.excecoes.ExcecaoRecursoNaoEncontrado;
import br.com.devance.fonar.models.Usuario;
import br.com.devance.fonar.repositorios.RepositorioUsuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

// Importe para logging
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/usuarios") // Endpoint base para operações de usuário
public class ControladorUsuarios {

    private static final Logger logger = LoggerFactory.getLogger(ControladorUsuarios.class);

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    // Endpoint para listar todos os usuários
    // Este endpoint deve ser protegido, por exemplo, apenas para SUPER_ADMIN
    @GetMapping
    public ResponseEntity<List<DTOSaidaUsuario>> listarTodosUsuarios() {
        logger.info("Requisição para listar todos os usuários recebida.");
        List<Usuario> usuarios = repositorioUsuario.findAll(); // Busca todos os usuários

        // Mapeia a lista de entidades Usuario para uma lista de DTOSaidaUsuario
        List<DTOSaidaUsuario> dtos = usuarios.stream()
                .map(usuario -> new DTOSaidaUsuario(
                        usuario.getId(),
                        usuario.getNome(),
                        usuario.getCpf(),
                        usuario.getEmail(),
                        usuario.getPerfil()
                ))
                .collect(Collectors.toList());

        logger.info("Retornando {} usuários.", dtos.size());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTOSaidaUsuario> obterUsuarioPorId(@PathVariable Long id) {
        logger.info("Requisição para obter usuário com ID: {}", id);
        Usuario usuario = repositorioUsuario.findById(id)
                .orElseThrow(() -> new ExcecaoRecursoNaoEncontrado("Usuário com ID " + id + " não encontrado."));

        DTOSaidaUsuario dto = new DTOSaidaUsuario(
                usuario.getId(),
                usuario.getNome(),
                usuario.getCpf(),
                usuario.getEmail(),
                usuario.getPerfil()
        );
        logger.info("Retornando detalhes do usuário com ID: {}", id);
        return ResponseEntity.ok(dto);
    }

    // NOVO: Endpoint para atualizar um usuário existente
    // Protegido por hasRole("SUPER_ADMIN") na SecurityConfiguration
    @PutMapping("/{id}")
    public ResponseEntity<DTOSaidaUsuario> atualizarUsuario(@PathVariable Long id, @RequestBody @Valid DTOAtualizacaoUsuario dadosAtualizacao) {
        logger.info("Requisição para atualizar usuário com ID: {}", id);
        Usuario usuarioExistente = repositorioUsuario.findById(id)
                .orElseThrow(() -> new ExcecaoRecursoNaoEncontrado("Usuário com ID " + id + " não encontrado para atualização."));

        // Atualiza os campos que podem ser modificados
        if (dadosAtualizacao.getNome() != null && !dadosAtualizacao.getNome().isEmpty()) {
            usuarioExistente.setNome(dadosAtualizacao.getNome());
        }
        if (dadosAtualizacao.getEmail() != null && !dadosAtualizacao.getEmail().isEmpty()) {
            usuarioExistente.setEmail(dadosAtualizacao.getEmail());
        }
        // A senha deve ser atualizada apenas se uma nova senha for fornecida
        if (dadosAtualizacao.getSenha() != null && !dadosAtualizacao.getSenha().isEmpty()) {
            usuarioExistente.setSenha(new BCryptPasswordEncoder().encode(dadosAtualizacao.getSenha()));
        }
        // O perfil pode ser alterado apenas por SUPER_ADMIN, mas a lógica de negócio deve ser mais robusta
        // Aqui, apenas atualizamos se o DTO fornecer um perfil.
        if (dadosAtualizacao.getPerfil() != null) {
            usuarioExistente.setPerfil(dadosAtualizacao.getPerfil());
        }
        // Outros campos como 'ativo', 'tentativasFalhas', 'dataBloqueio' podem ser atualizados aqui também.
        if (dadosAtualizacao.getAtivo() != null) {
            usuarioExistente.setAtivo(dadosAtualizacao.getAtivo());
        }
        if (dadosAtualizacao.getTentativasFalhas() != null) {
            usuarioExistente.setTentativasFalhas(dadosAtualizacao.getTentativasFalhas());
        }
        // dataBloqueio pode ser atualizado para null (desbloquear) ou LocalDateTime.now() (bloquear)
        if (dadosAtualizacao.getDataBloqueio() != null) {
            usuarioExistente.setDataBloqueio(dadosAtualizacao.getDataBloqueio());
        }


        Usuario usuarioAtualizado = repositorioUsuario.save(usuarioExistente);

        DTOSaidaUsuario dtoSaida = new DTOSaidaUsuario(
                usuarioAtualizado.getId(),
                usuarioAtualizado.getNome(),
                usuarioAtualizado.getCpf(),
                usuarioAtualizado.getEmail(),
                usuarioAtualizado.getPerfil()
        );
        logger.info("Usuário com ID {} atualizado com sucesso.", id);
        return ResponseEntity.ok(dtoSaida);
    }

    // NOVO: Endpoint para deletar um usuário
    // Protegido por hasRole("SUPER_ADMIN") na SecurityConfiguration
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        logger.info("Requisição para deletar usuário com ID: {}", id);
        if (!repositorioUsuario.existsById(id)) {
            throw new ExcecaoRecursoNaoEncontrado("Usuário com ID " + id + " não encontrado para exclusão.");
        }
        repositorioUsuario.deleteById(id);
        logger.info("Usuário com ID {} deletado com sucesso.", id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content para exclusão bem-sucedida
    }

}
