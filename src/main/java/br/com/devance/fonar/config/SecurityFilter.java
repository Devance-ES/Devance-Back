package br.com.devance.fonar.config;

import br.com.devance.fonar.models.Usuario; // Para buscar o usuário

import br.com.devance.fonar.repositorios.RepositorioUsuario; // Repositório para buscar o usuário

import br.com.devance.fonar.servicos.TokenService; // Serviço para validar o token JWT

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken; // Para o token de autenticação
import org.springframework.security.core.context.SecurityContextHolder; // Para o contexto de segurança
import org.springframework.security.core.userdetails.UserDetails; // Para criar o UserDetails
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter; // Garante que o filtro seja executado uma vez por requisição

import java.io.IOException;

@Component // Marca a classe como um componente Spring
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService; // Serviço que vamos criar para gerar/validar o token

    @Autowired
    private RepositorioUsuario repositorioUsuario; // Para buscar o usuário no banco de dados

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = recoverToken(request); // Recupera o token da requisição

        if (token != null) {
            String login = tokenService.validateToken(token); // Valida o token e retorna o login (CPF/Email)
            // Se o login for válido, carrega os detalhes do usuário
            UserDetails userDetails = repositorioUsuario.findByCpf(login)
                    .orElseGet(() -> repositorioUsuario.findByEmail(login)
                            .orElse(null)); // Usuário deve existir se o token é válido

            if (userDetails != null) {
                // Cria um objeto de autenticação e o define no contexto de segurança do Spring
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request, response); // Continua a cadeia de filtros
    }

    // Método auxiliar para recuperar o token do header da requisição
    private String recoverToken(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return null;
        }
        return authHeader.replace("Bearer ", "");
    }
}