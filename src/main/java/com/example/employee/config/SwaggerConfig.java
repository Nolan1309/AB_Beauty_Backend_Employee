package com.example.employee.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
@Configuration
@ComponentScan(basePackages = "com.example.employee.controller")
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                    .info(new Info().title("JavaInUse Authentication Service"))
                    .addSecurityItem(new SecurityRequirement().addList("JavaInUseSecurityScheme"))
                    .components(new Components().addSecuritySchemes("JavaInUseSecurityScheme", new SecurityScheme()
                            .name("JavaInUseSecurityScheme").type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")));

    }
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.OAS_30)  // Sử dụng OpenAPI 3.0
//                    .select()
//                    .apis(RequestHandlerSelectors.basePackage("com.example.employee.controller"))  // Chỉ quét API trong package controller
//                    .build();
//    }
}

