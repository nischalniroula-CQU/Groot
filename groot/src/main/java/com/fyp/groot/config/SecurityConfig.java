package com.fyp.groot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests(authz -> authz
                .requestMatchers("/index", "/", "/api/login", "/login", "/signup", "/header", "/footer", "/admin**", "/add**", "/css/**", "/js/**", "/img/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/index").authenticated()  // Ensure GET requests to /index are authenticated.
                .anyRequest().authenticated())
            .logout(logout -> logout
                .permitAll());

        return http.build();
    }
}
