package com.example.demo.config;


import java.net.UnknownHostException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.*;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@WebServlet(name = "SwaggerJaxrsConfig", loadOnStartup = 2)
public class SwaggerConfig extends HttpServlet {

    private static final String API_VERSION = "1.0";
    private static final String API_TITLE = "Pesatel Mobile Alternative Banking Channel";
    private static final String API_DESCRIPTION = "Directcore Pesatel Mobile Alternative Banking Banking Channel Api";
    private static final String LICENSE_TEXT = "API License";
    private static final String LICENSE_URL = "http://directcore.com";

    private static final String DEVELOPER_NAME = "Jacob Kisoi";
    private static final String DEVELOPER_URL = "http://directcore.com";
    private static final String DEVELOPER_EMAIL = "jkisoi@directcore.com";
    private static final long serialVersionUID = 1L;

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .version(API_VERSION)
                .title(API_TITLE)
                .description(API_DESCRIPTION)
                .license(LICENSE_TEXT)
                .licenseUrl(LICENSE_URL)
                .contact(new Contact(DEVELOPER_NAME, DEVELOPER_URL, DEVELOPER_EMAIL))
                .build();
    }

    @Bean
    public Docket api() throws ServletException, UnknownHostException {

        return new Docket(DocumentationType.SPRING_WEB)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controllers"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());

    }

}