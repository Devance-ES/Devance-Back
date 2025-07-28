package br.com.devance.fonar.controladores;

import br.com.devance.fonar.dto.DTOCadastroUsuario;
import br.com.devance.fonar.excecoes.ExcecaoRecursoNaoEncontrado;
import br.com.devance.fonar.dto.DTOAuthRequest;
import br.com.devance.fonar.dto.DTOAuthResponse;
import br.com.devance.fonar.models.Delegado;
import br.com.devance.fonar.models.FuncionarioSecundario;
import br.com.devance.fonar.models.SuperAdministrador;
import br.com.devance.fonar.models.Usuario;
import br.com.devance.fonar.repositorios.RepositorioUsuario;
import br.com.devance.fonar.servicos.ServicoAutenticacao;
import br.com.devance.fonar.servicos.TokenService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Importe para logging
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

import static br.com.devance.fonar.enums.PerfilUsuario.DELEGADO;
import static br.com.devance.fonar.enums.PerfilUsuario.FUNCIONARIO_SECUNDARIO;

@RestController
@RequestMapping("/auth")
public class ControladorAutenticacao {

    // Adicione um logger para depuração
    private static final Logger logger = LoggerFactory.getLogger(ControladorAutenticacao.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private ServicoAutenticacao servicoAutenticacao;

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid DTOAuthRequest dados) {
        logger.debug("Tentando login para CPF/Email: {}", dados.getCpf());
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(dados.getCpf(), dados.getSenha());

            logger.debug("Autenticando usuário com AuthenticationManager...");
            Authentication auth = this.authenticationManager.authenticate(usernamePassword);
            logger.debug("Usuário autenticado com sucesso pelo AuthenticationManager.");

            UserDetails userDetails = (UserDetails) auth.getPrincipal();

            if (!(userDetails instanceof Usuario)) {
                logger.error("Principal não é uma instância de Usuario. Tipo real: {}", userDetails.getClass().getName());
                throw new IllegalStateException("Tipo de principal inesperado após autenticação.");
            }

            Usuario usuario = (Usuario) userDetails;
            String token = tokenService.generateToken(usuario);

            return ResponseEntity.ok(DTOAuthResponse.builder()
                    .token(token)
                    .userId(usuario.getId())
                    .cpf(usuario.getCpf())
                    .perfil(usuario.getPerfil())
                    .message("Login bem-sucedido!") // Mensagem padrão para sucesso
                    .build());

        } catch (BadCredentialsException e) { // Captura a exceção específica de credenciais inválidas
            logger.warn("Tentativa de login falhou para CPF/Email: {}", dados.getCpf());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas.");
        } catch (Exception e) {
            logger.error("Um erro inesperado ocorreu durante o login para CPF/Email: {}", dados.getCpf(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno no servidor: " + e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody @Valid DTOCadastroUsuario dados) {
        logger.debug("Tentando registrar novo usuário: {}", dados.getCpf());
        if (this.repositorioUsuario.findByCpf(dados.getCpf()).isPresent() || this.repositorioUsuario.findByEmail(dados.getEmail()).isPresent()) {
            logger.warn("Tentativa de registro de usuário já existente: {}", dados.getCpf());
            return ResponseEntity.badRequest().body("Usuário já existe.");
        }

        String senhaCriptografada = new BCryptPasswordEncoder().encode(dados.getSenha());

        Usuario novoUsuario;
        switch (dados.getPerfil()) {
            case DELEGADO:
                novoUsuario = new Delegado(dados.getNome(), dados.getCpf(), dados.getEmail(), senhaCriptografada,
                        dados.getDataNascimento(), dados.getPerfil(), null,  null);
                break;
            case FUNCIONARIO_SECUNDARIO:
                novoUsuario = new FuncionarioSecundario(dados.getNome(), dados.getCpf(), dados.getEmail(),
                        senhaCriptografada, dados.getDataNascimento(), dados.getPerfil(), null,  null);
                break;
            case SUPER_ADMIN:
                novoUsuario = new SuperAdministrador(dados.getNome(), dados.getCpf(), dados.getEmail(),
                        senhaCriptografada, dados.getDataNascimento(), "",   dados.getPerfil());
                break;

            default:
                return ResponseEntity.badRequest().body("Perfil de usuário inválido.");
        }

        this.repositorioUsuario.save(novoUsuario);
        logger.debug("Usuário registrado com sucesso: {}", dados.getCpf());
        return ResponseEntity.ok("Usuário registrado com sucesso.");
    }
}
