package br.com.devance.fonar.controladores;

import br.com.devance.fonar.dto.DTOCadastroUsuario;
import br.com.devance.fonar.excecoes.ExcecaoRecursoNaoEncontrado; // Para tratamento de erros
import br.com.devance.fonar.dto.DTOAuthRequest;
import br.com.devance.fonar.dto.DTOAuthResponse;
import br.com.devance.fonar.models.Usuario;
import br.com.devance.fonar.repositorios.RepositorioUsuario;
import br.com.devance.fonar.servicos.ServicoAutenticacao;
import br.com.devance.fonar.servicos.TokenService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class ControladorAutenticacao {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService; // Serviço para gerar o JWT

    @Autowired
    private ServicoAutenticacao servicoAutenticacao;

    @Autowired
    private RepositorioUsuario repositorioUsuario; // Para buscar o objeto Usuario completo

    @PostMapping("/login") // Endpoint POST para login
    public ResponseEntity<DTOAuthResponse> login(@Valid @RequestBody DTOAuthRequest authRequest) {
        // Cria um token de autenticação com as credenciais fornecidas
        UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getSenha());

        try {
            // Tenta autenticar o usuário. Se falhar, uma exceção será lançada.
            Authentication auth = this.authenticationManager.authenticate(usernamePassword);

            // Se a autenticação foi bem-sucedida, o objeto 'auth.getPrincipal()' contém os UserDetails.
            // Precisamos do objeto Usuario completo para pegar o ID e o perfil real.
            Usuario usuarioLogado = (Usuario) auth.getPrincipal(); // Cast para sua entidade Usuario

            // Gera o JWT usando o TokenService
            String token = tokenService.generateToken(usuarioLogado);

            return ResponseEntity.ok(new DTOAuthResponse(
                    token,
                    usuarioLogado.getId(),
                    usuarioLogado.getCpf(),
                    usuarioLogado.getPerfil(),
                    "Login bem-sucedido!"
            ));

        } catch (UsernameNotFoundException e) {
            // Trata o caso de usuário não encontrado (ou inativo/bloqueado)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new DTOAuthResponse(null, null, null, null, "Credenciais inválidas: Usuário não encontrado ou inativo/bloqueado."));
        } catch (Exception e) {
            // Captura outras exceções (ex: BadCredentialsException para senha incorreta)
            // Para BadCredentialsException, o status também é 401 Unauthorized
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new DTOAuthResponse(null, null, null, null, "Credenciais inválidas."));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Usuario> register(@Valid @RequestBody DTOCadastroUsuario dtoCadastro) {
        try {
            Usuario novoUsuario = servicoAutenticacao.registrarUsuario(dtoCadastro);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // Retorne um corpo de erro mais útil aqui
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Retorne um corpo de erro mais útil aqui
        }
    }
}