package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorssConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOriginPattern("*"); // Permitir cualquier origen
        config.addAllowedHeader("*"); // Permitir cualquier cabecera
        config.addAllowedMethod("POST"); // Permitir cualquier método (GET, POST, PUT, DELETE, etc.)
        config.setAllowCredentials(true); // Permitir cookies/sesiones

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config); // Aplicar configuración a todos los endpoints
        return new CorsFilter(source);
    }
}
