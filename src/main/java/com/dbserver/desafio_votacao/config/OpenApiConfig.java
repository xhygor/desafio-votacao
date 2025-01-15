package com.dbserver.desafio_votacao.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import jakarta.servlet.ServletContext;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@RequiredArgsConstructor
public class OpenApiConfig {

    private static final String TITLE = "Desafio Votação";
    private static final String DESCRICAO = "API criada para cumprir desafio técnico proposto em processo seletivo.";
    private static final String LICENCA_PRIVADO = "Licença - PRIVADO";
    private static final String CONTACT_NAME = "Hygor de Barros Santos Silva";
    private static final String CONTACT_EMAIL = "hygordebarross@gmail.com";

    private final ServletContext servletContext;

    @Bean
    @Scope("application")
    public OpenAPI springOpenAPI() {
        return new OpenAPI()
                .addServersItem(new Server().url(servletContext.getContextPath()))
                .info(getInfo());
    }


    public Info getInfo() {
        return new Info().title(TITLE)
                .description(DESCRICAO)
                .contact(getContact())
                .license(new License().name(LICENCA_PRIVADO));
    }

    public Contact getContact() {
        return new Contact().name(CONTACT_NAME).email(CONTACT_EMAIL);
    }
}
