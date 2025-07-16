package br.com.devance.fonar.servicos;

import br.com.devance.fonar.models.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    // A chave secreta para assinar e verificar o token.
    // Ela será injetada do application.properties
    @Value("${app.security.jwt.secret}")
    private String secret;

    // Metodo para gerar um token JWT
    public String generateToken(Usuario usuario) {
        try {
            // Define o algoritmo de assinatura com a chave secreta
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("api.fonar") // Emissor do token (sua API)
                    .withSubject(usuario.getCpf()) // Sujeito do token (identificador do usuário, ex: CPF)
                    .withExpiresAt(genExpirationDate()) // Define o tempo de expiração
                    .sign(algorithm); // Assina o token com o algoritmo
            return token;
        } catch (JWTCreationException exception) {
            // Lança uma exceção se houver falha na criação do token
            throw new RuntimeException("Erro ao gerar o token JWT.", exception);
        }
    }

    // Metodo para validar um token JWT
    public String validateToken(String token) {
        try {
            // Usa o mesmo algoritmo e chave secreta para verificar o token
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("api.fonar") // Valida o emissor
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception) {

            return null; // Token inválido ou expirado
        }
    }

    // Metodo auxiliar para gerar a data de expiração (ex: 2 horas a partir de agora)
    private Instant genExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00")); // +2 horas, fuso horário de Brasília
    }
}