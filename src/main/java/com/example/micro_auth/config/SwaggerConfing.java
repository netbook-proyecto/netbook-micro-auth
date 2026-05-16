package com.example.micro_auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfing {

    @Ben
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
            .info(new Info()
                .title("API auth netbook")
                .version("1.0.0")
                .description("Microservico de Seguridad y Autenticacion JWT")
                .contact(new Contact().name("Cristopher Candia - Arquitectura Netbook")));
            
    }
}
