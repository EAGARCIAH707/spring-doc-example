package com.andevs.springdoc.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
    info =
        @Info(
            title = "spring-doc-api-example",
            version = "v1",
            description = "Api de ejemplo para springdoc",
            contact =
                @Contact(
                    name = "Edisson Andrés Garcia",
                    email = "edisson.garcia@wearedev.co",
                    url = "https://www.linkedin.com/in/edisson-andres-garcia-herrera-63a91517b"),
            license =
                @License(
                    name = "Apache 2.0",
                    url = "http://www.apache.org/licenses/LICENSE-2.0.html")),
    servers = {
      @Server(url = "http://localhost:8080/spring-doc-api-example/v1"),
      @Server(url = "https://www.andevs.com.co/spring-doc-api-example/v1")
    })
@SecurityScheme(
    name = "bearerAuth",
    type = SecuritySchemeType.HTTP,
    bearerFormat = "JWT",
    scheme = "bearer",
    description = "Esto es un ejemplo de descripcion")
public class OpenApiConfig {}
