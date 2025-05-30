package com.wavekanit.Java_Spring_Authen_System.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**")) // ✅ disable csrf เฉพาะ h2
                .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin())) // ✅ for iframe (h2 UI)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll() // ✅ allow h2
                        .anyRequest().permitAll() // ✅ allow ทุก request (ในตอนนี้)
                );

        return http.build();
    }
}