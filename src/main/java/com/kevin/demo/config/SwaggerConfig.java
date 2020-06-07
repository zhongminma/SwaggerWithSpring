package com.kevin.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket docket1() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("team1");
    }
    @Bean
    public Docket docket2() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("team2");
    }
    // config swagger bean instance
    @Bean
    public Docket docket(Environment env) {
        Profiles profile = Profiles.of("dev","test");
        boolean flag = env.acceptsProfiles(profile);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(info())
                .enable(flag) // disable swagger usage
                .select()
                // RequestHandlerSelectors config interface scanning
                // .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .apis(RequestHandlerSelectors.basePackage("com.kevin.demo.controller"))
                // filter controller should be used
                //.paths(PathSelectors.ant("kevin/**"))
                .build();
    }
    // ApiInfo: config title and description, etc
    Contact contact =new Contact("Kevin Ma", "abc", "xyz");
    private ApiInfo info() {
        return new ApiInfo(
                "Swagger Api Docs",
                "Demo for Swagger Api usage",
                "1.0", "Kevin LinkedIn",
                contact, "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
