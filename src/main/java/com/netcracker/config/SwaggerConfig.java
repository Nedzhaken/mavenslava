package com.netcracker.config;

import com.netcracker.controller.StyleController;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

//import static springfox.documentation.builders.PathSelectors.regex;

//@EnableSwagger2
@PropertySource("classpath:swagger.properties")
@ComponentScan(basePackageClasses = StyleController.class)
@Configuration
public class SwaggerConfig {

//    @Bean
//    public Docket productApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.techprimers.springboot.swaggerexample"))
//                .paths(regex("/rest.*"))
//                .build()
//                .apiInfo(metaInfo());
//    }
//
//    private ApiInfo metaInfo() {
//
//        ApiInfo apiInfo = new ApiInfo(
//                "Spring Boot Swagger Example API",
//                "Spring Boot Swagger Example API for Youtube",
//                "1.0",
//                "Terms of Service",
//                new Contact("TechPrimers", "https://www.youtube.com/TechPrimers",
//                        "techprimerschannel@gmail.com"),
//                "Apache License Version 2.0",
//                "https://www.apache.org/licesen.html"
//        );
//
//        return apiInfo;
//    }

//    private static final String SWAGGER_API_VERSION = "1.0";
//    private static final String LICENSE_TEXT = "License";
//    private static final String title = "Products REST API";
//    private static final String description = "RESTful API for Products";
//
//    private ApiInfo apiInfo(){
//        return new ApiInfoBuilder()
//                .title(title)
//                .description(description)
//                .license(LICENSE_TEXT)
//                .version(SWAGGER_API_VERSION)
//                .build();
//    }
//
//    @Bean
//    public Docket productsApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .pathMapping("/")
//                .select()
//                .paths(PathSelectors.regex("/api.*"))
//                .build();
//    }
}
