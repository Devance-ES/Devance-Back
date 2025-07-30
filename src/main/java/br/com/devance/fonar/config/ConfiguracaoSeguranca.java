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
                        .requestMatchers(HttpMethod.POST, "/error").permitAll()// Se ainda estiver temporário
                        .requestMatchers(HttpMethod.POST, "/api/delegacias").hasRole("SUPER_ADMIN") // Criar delegacia
                        // Permite que SUPER_ADMIN e DELEGADO cadastrem funcionários secundários
                        .requestMatchers(HttpMethod.POST, "/api/delegacias/{id}/funcionarios").hasAnyRole("SUPER_ADMIN", "DELEGADO")

                        // Endpoints do ControladorUsuario
                        .requestMatchers(HttpMethod.GET, "/usuarios").hasRole("SUPER_ADMIN") // Listar todos
                        .requestMatchers(HttpMethod.GET, "/usuarios/{id}").hasAnyRole("SUPER_ADMIN", "DELEGADO", "FUNCIONARIO_SECUNDARIO") // Obter por ID (Delegado e Funcionário podem ver detalhes de si mesmos ou outros, dependendo da regra de negócio mais granular)
                        .requestMatchers(HttpMethod.PUT, "/usuarios/{id}").hasRole("SUPER_ADMIN") // Atualizar (apenas SUPER_ADMIN por enquanto)
                        .requestMatchers(HttpMethod.DELETE, "/usuarios/{id}").hasRole("SUPER_ADMIN") // Deletar (apenas SUPER_ADMIN)

                        // Endpoints Upload OCR
                        .requestMatchers(HttpMethod.DELETE, "/api/fonars/ocr-upload").hasRole("SUPER_ADMIN") // Deletar (apenas SUPER_ADMIN)

                        .anyRequest().authenticated()
                )
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
