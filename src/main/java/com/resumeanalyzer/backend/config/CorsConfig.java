package com.resumeanalyzer.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.*;

import java.util.List;

@Configuration
public class CorsConfig {

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration configuration =
                new CorsConfiguration();

       configuration.setAllowedOrigins(
        List.of(
                "https://ai-resume-analyzer-kappa-rust-43.vercel.app",
                "https://ai-resume-analyzer-git-main-farman396s-projects.vercel.app",
                "https://ai-resume-analyzer-2a5id7eda-farman396s-projects.vercel.app"
        )
);

        configuration.setAllowedMethods(
                List.of("*")
        );

        configuration.setAllowedHeaders(
                List.of("*")
        );

        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration(
                "/**",
                configuration
        );

        return source;
    }
}
