package br.com.devance.fonar.config;

import br.com.devance.fonar.repositorios.RepositorioUsuario;
import br.com.devance.fonar.servicos.ServicoAutenticacao;
import br.com.devance.fonar.servicos.TokenService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private ServicoAutenticacao servicoAutenticacao;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token = recoverToken(request);

        if (token != null) {
            String login = tokenService.validateToken(token);
            if (login != null && !login.isEmpty()) { // Verifica se o login não é nulo ou vazio
                try {
                    // CORRIGIDO: Usando o ServicoAutenticacao para carregar os detalhes do usuário
                    UserDetails userDetails = servicoAutenticacao.loadUserByUsername(login);

                    // Se userDetails foi encontrado, autentica
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,
                            null, userDetails.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    logger.debug("Usuário {} autenticado via token JWT.");

                } catch (UsernameNotFoundException e) {
                    // Isso pode acontecer se o token for válido, mas o usuário não existe mais no DB
                    logger.warn("Token JWT válido para usuário não encontrado no sistema: {}");
                    // Não define a autenticação, a requisição seguirá como anônima ou será rejeitada posteriormente
                } catch (Exception e) {
                    logger.error("Erro inesperado ao processar token JWT para login {}: {}");
                    // Não define a autenticação
                }
            } else {
                logger.warn("Token JWT válido, mas subject (login) é nulo ou vazio.");
            }
        } else {
            logger.debug("Nenhum token JWT encontrado ou token mal formatado no header Authorization.");
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
