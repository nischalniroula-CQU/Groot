package com.fyp.groot.commons.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * SecurityConfig class for configuring the security settings of the application.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Configures the security filter chain.
     * 
     * @param http the HttpSecurity object to configure
     * @return the configured SecurityFilterChain
     * @throws Exception if an error occurs during configuration
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // Disable CSRF protection as it's not needed for this application
            .csrf().disable()
            // Configure authorization requests
            .authorizeRequests(authz -> authz
                // Allow public access to these endpoints
                .requestMatchers("/index", "/", "/api/login", "/login", "/about", "/signup", "/review", "/business-signup", "/categories", "/owner**", "/ownerHeader", "/listing**", "/api/**", "/business", "/header", "/footer", "/admin**", "/add**", "/css/**", "/js/**", "/img/**").permitAll()
                // Ensure GET requests to /index are authenticated
                .requestMatchers(HttpMethod.GET, "/index").authenticated()
                // All other requests require authentication
                .anyRequest().authenticated())
            // Configure logout functionality
            .logout(logout -> logout
                // Allow all users to log out
                .permitAll());

        // Build and return the SecurityFilterChain
        return http.build();
    }
}
