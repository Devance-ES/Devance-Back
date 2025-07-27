package br.com.devance.fonar.config;

import br.com.devance.fonar.servicos.ServicoAutenticacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class ConfiguracaoSeguranca {

    @Autowired
    private ServicoAutenticacao servicoAutenticacao;

    @Autowired
    private SecurityFilter securityFilter; // Mantenha a injeção

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean // Configura a cadeia de filtros de segurança HTTP
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // Desabilita CSRF para APIs REST
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        // Endpoints públicos (login e registro) - NÃO SERÃO FILTRADOS PELO securityFilter
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
                        .requestMatchers(HttpMethod.POST, "/fonar/publico").permitAll()
                        // Outros endpoints protegidos por autenticação
                        .anyRequest().authenticated() // Qualquer outra requisição DEVE ser autenticada
                )
                // Adiciona nosso filtro JWT SOMENTE para as requisições que NÃO são públicas
                // Ao fazer isso, o SecurityFilter não será executado para /auth/login,
                // permitindo que o UsernamePasswordAuthenticationFilter (padrão) lide com ele.
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    // Bean para o AuthenticationManager, que lida com o processo de autenticação
    @Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(servicoAutenticacao);
        authProvider.setPasswordEncoder(passwordEncoder);
        return new ProviderManager(authProvider);
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(servicoAutenticacao); // Diz ao provedor para usar SEU ServicoAutenticacao
        authProvider.setPasswordEncoder(passwordEncoder); // Diz ao provedor para usar SEU PasswordEncoder
        return authProvider;
    }
}
