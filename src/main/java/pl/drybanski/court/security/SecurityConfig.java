package pl.drybanski.court.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http ) throws Exception {
        return http
                .csrf( csrf -> csrf.disable() )
                .headers( headers -> headers.disable() ) // for H2 console
                .sessionManagement( session -> session.sessionCreationPolicy( SessionCreationPolicy.STATELESS) )
                .authorizeHttpRequests(
                        auth -> auth.anyRequest().permitAll()
                ).build();
    }
}
