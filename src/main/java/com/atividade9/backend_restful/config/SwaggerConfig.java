package com.atividade9.backend_restful.config;  // Certifique-se de que o pacote seja o correto!

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.atividade9.backend_restful.controller"))  // Ajuste aqui se necessário
                .paths(PathSelectors.any())
                .build();
    }
}

