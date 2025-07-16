package br.com.devance.fonar.config;

import br.com.devance.fonar.servicos.ServicoAutenticacao; // Seu serviço de autenticação (UserDetailsService)
import br.com.devance.fonar.config.SecurityFilter; // Importa o SecurityFilter que iremos criar

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod; // Para especificar métodos HTTP em requestMatchers
import org.springframework.security.authentication.AuthenticationManager; // Gerenciador de autenticação
import org.springframework.security.authentication.ProviderManager; // Para construir AuthenticationManager
import org.springframework.security.authentication.dao.DaoAuthenticationProvider; // Provedor de autenticação
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration; // Para injetar AuthenticationManager
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy; // Para session stateless
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // Para hashear senhas
import org.springframework.security.crypto.password.PasswordEncoder; // Interface do encoder
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter; // Para adicionar nosso filtro JWT

@Configuration
@EnableWebSecurity
public class ConfiguracaoSeguranca {

    @Autowired
    private ServicoAutenticacao servicoAutenticacao;

    @Autowired
    private SecurityFilter securityFilter;

    @Bean // Configura a cadeia de filtros de segurança HTTP
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // Desabilita CSRF para APIs REST
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        // Endpoints públicos (login e registro)
                        .requestMatchers(HttpMethod.POST, "/api/v1/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/v1/auth/register").permitAll()// Se você tiver um endpoint de registro
                        .requestMatchers(HttpMethod.POST, "/fonar/publico").permitAll() // FONAR público
                        // Outros endpoints protegidos por autenticação
                        .anyRequest().authenticated() // Qualquer outra requisição DEVE ser autenticada
                )
                // Adiciona nosso filtro JWT ANTES do filtro padrão de autenticação por usuário/senha
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    // Bean para o AuthenticationManager, que lida com o processo de autenticação
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    // Configura o provedor de autenticação (DaoAuthenticationProvider)
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(servicoAutenticacao); // Define o nosso serviço para carregar usuários
        authProvider.setPasswordEncoder(passwordEncoder()); // Define o encoder de senha
        return authProvider;
    }

    // Bean para o codificador de senhas (BCrypt)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Usar BCrypt para senhas hash
    }
}