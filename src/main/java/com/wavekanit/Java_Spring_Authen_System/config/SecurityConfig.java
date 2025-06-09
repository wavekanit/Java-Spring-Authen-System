package com.wavekanit.Java_Spring_Authen_System.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // ✅ disable csrf
                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin)) // ✅ for iframe (h2 UI)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/h2-console/**",    // ✅ allow h2 console
                                "/api/user/**",      // ✅ allow auth path เช่น login, register
                                "/public/**"         // ✅ allow public path
                        ).permitAll()
                        .anyRequest().authenticated() // ✅ allow ทุก request (ในตอนนี้)
                );

        return http.build();
    }
}