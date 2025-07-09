package br.com.devance.fonar.controladores;

import br.com.devance.fonar.excecoes.ExcecaoRecursoNaoEncontrado;
import br.com.devance.fonar.dto.DTOAuthRequest; // DTO para requisição de login (atualizado)
import br.com.devance.fonar.dto.DTOAuthResponse; // DTO para resposta de login (atualizado)
import br.com.devance.fonar.models.Usuario; // Entidade Usuario

import br.com.devance.fonar.repositorios.RepositorioUsuario; // Repositório para buscar o Usuario completo
import br.com.devance.fonar.servicos.ServicoAutenticacao; // Seu serviço de autenticação (UserDetailsService)

import jakarta.validation.Valid; // Para validar o DTO de entrada

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication; // Objeto de autenticação do Spring Security
import org.springframework.security.core.context.SecurityContextHolder; // Para acessar o contexto de segurança
import org.springframework.security.core.userdetails.UsernameNotFoundException; // Exceção para usuário não encontrado
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth") // Caminho base para autenticação
public class ControladorAutenticacao {

    @Autowired
    private RepositorioUsuario repositorioUsuario; // Injetado para buscar o objeto Usuario completo após autenticação

    // O ServicoAutenticacao (que implementa UserDetailsService) é usado internamente pelo Spring Security.
    // Não precisamos injetá-lo diretamente aqui, pois o AuthenticationManager é que o utiliza.

    @PostMapping("/login") // Endpoint POST para login
    public ResponseEntity<DTOAuthResponse> login(@Valid @RequestBody DTOAuthRequest authRequest) {
        // Quando uma requisição com Basic Auth chega a este endpoint, se as credenciais estiverem corretas,
        // o Spring Security já terá autenticado o usuário e preenchido o SecurityContextHolder ANTES de chegar aqui.

        try {
            // Obtemos o objeto de autenticação do contexto de segurança do Spring
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            // Verificamos se a autenticação foi bem-sucedida e o usuário está logado
            if (authentication != null && authentication.isAuthenticated()) {
                // O nome principal (principal.getName()) será o username que você usou no login (CPF ou email)
                String username = authentication.getName();

                // Buscamos o objeto Usuario completo no banco de dados
                Usuario usuarioLogado = repositorioUsuario.findByCpf(username)
                        .orElseGet(() -> repositorioUsuario.findByEmail(username)
                                .orElseThrow(() -> new ExcecaoRecursoNaoEncontrado("Usuário autenticado não encontrado no banco de dados.")));

                // Em um sistema real, aqui você geraria um JWT (JSON Web Token)
                // e o retornaria na resposta para ser usado em requisições futuras.
                String tokenGerado = "dummy-jwt-token-para-usuario-" + usuarioLogado.getId();

                return ResponseEntity.ok(new DTOAuthResponse(
                        tokenGerado,
                        usuarioLogado.getId(),
                        usuarioLogado.getCpf(), // Retorna o CPF
                        usuarioLogado.getPerfil(), // Assume que getPerfil() retorna o enum PerfilUsuario da entidade Usuario
                        "Login bem-sucedido!"
                ));
            } else {
                // Este bloco seria atingido se a autenticação falhar ANTES de chegar aqui,
                // ou se houver um problema no fluxo de segurança.
                // Na prática, o filtro HTTP Basic já retornaria 401 antes.
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new DTOAuthResponse(null, null, null, null, "Falha na autenticação ou credenciais inválidas."));
            }
        } catch (UsernameNotFoundException | ExcecaoRecursoNaoEncontrado e) {
            // Captura exceções específicas de usuário não encontrado ou recurso não encontrado
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new DTOAuthResponse(null, null, null, null, "Credenciais inválidas: " + e.getMessage()));
        } catch (Exception e) {
            // Captura outras exceções inesperadas
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new DTOAuthResponse(null, null, null, null, "Erro interno no servidor durante o login: " + e.getMessage()));
        }
    }
}