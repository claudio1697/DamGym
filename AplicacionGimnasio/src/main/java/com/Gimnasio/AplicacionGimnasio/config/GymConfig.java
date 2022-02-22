package com.Gimnasio.AplicacionGimnasio.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Clase Config que nos hace link con el Swagger.ui
 */
@Configuration
@EnableTransactionManagement
public class GymConfig {
    /**
     * Nos devuelve la pagina
     * @return
     */
    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("DamGym")
                        .description("Gimnasio en donde se reservan clases deportivas")
                        .contact(new Contact()
                                .name ("SFC")
                                .email("dam_gym12@mejorgym.com")
                                .url("https://datos.gym.com"))
                        .version("1.0"));
    }
}
