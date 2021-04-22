package com.service.cep.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
public class ApplicationConfigurations {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public Docket awesomeApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(this.awesomeApiInfo())
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.service.cep.controller"))
                .build();

    }

    private ApiInfo awesomeApiInfo() {
        return new ApiInfo(
                "Magalu CEP test",
                "Exemplo de Api", "1.0",
                "http://linkTermsOfServiceUrl",
                new Contact("MagaluExemplo","http://urlContract","marco_aurelioo@yahoo.com.br") ,
                "MIT", "http://linkLicenseUrl",
                new ArrayList<VendorExtension>()
        );
    }

}
