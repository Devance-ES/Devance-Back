package br.com.devance.fonar.config;

import br.com.devance.fonar.repositorios.RepositorioUsuario;
import br.com.devance.fonar.servicos.TokenService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Remova a lógica de if (requestURI.equals(...)) daqui
        // O SecurityFilterChain já garante que este filtro não será executado para as rotas permitidas.

        String token = recoverToken(request); // Recupera o token da requisição

        if (token != null) {
            String login = tokenService.validateToken(token); // Valida o token e retorna o login
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
        filterChain.doFilter(request, response);
    }

    // Metodo auxiliar para recuperar o token do header da requisição
    private String recoverToken(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return null;
        }
        return authHeader.replace("Bearer ", "");
    }
}
