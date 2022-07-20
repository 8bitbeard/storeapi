package br.com.pet.storeapi.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class OpenApiConfig {

  @Bean
  public OpenAPI openApi() {
    final String securitySchemaName = "AuthJWT";
    return new OpenAPI()
        .addSecurityItem(new SecurityRequirement().addList(securitySchemaName))
        .components(
            new Components()
                .addSecuritySchemes(
                    securitySchemaName,
                    new SecurityScheme()
                        .name(securitySchemaName)
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT")))
        .info(
            new Info()
                .title("PetStore API")
                .description("A PetStore API implemented for a Backend technical challenge")
                .version("1.0.0"));
  }
}
