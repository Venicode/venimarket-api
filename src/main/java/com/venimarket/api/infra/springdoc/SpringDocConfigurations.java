package com.venimarket.api.infra.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfigurations {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("VeniMarket API")
                        .description("API para sistema de mercado local. Com funcionalidades de " +
                                "cadastrar produto, fornecedor, cliente, métodos de pagamento, abrir e fechar caixa e realizar vendas;")
                        .contact(new Contact()
                                .name("GitHub")
                                .url("https://github.com/Venicode")));

    }
}
