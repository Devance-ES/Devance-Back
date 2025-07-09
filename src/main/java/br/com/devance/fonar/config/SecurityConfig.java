package br.com.devance.fonar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desabilita CSRF, pois API REST não usa cookies de sessão

                .authorizeHttpRequests(auth -> auth
                        // Endpoints públicos (sem autenticação)
                        .requestMatchers("/auth/login", "/fonar/publico").permitAll()

                        // Todo o resto exige autenticação
                        .anyRequest().authenticated()
                )

                // Sem formulário de login
                .formLogin(form -> form.disable())

                // Sem autenticação HTTP Basic
                .httpBasic(httpBasic -> httpBasic.disable())

                // Stateless: não cria sessão (ideal para APIs REST com JWT)
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );

        return http.build();
    }
}
