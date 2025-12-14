package com.example.eureka.config;



import com.example.eureka.security.JwtAuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.filter.GlobalFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtAuthFilter jwtAuthFilter;

    @Bean
    public GlobalFilter jwtFilterGlobal() {
        return (exchange, chain) -> jwtAuthFilter.filter(exchange, chain);
    }
}

