package com.kk.rest.config;

import com.kk.rest.controller.HelloWorldController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SwaggerConfig
 *
 * @author juejin
 * @datetime 2022/2/10
 */
@Configuration
@EnableSwagger2
//@Profile({"dev", "test"})
public class SwaggerConfig {

    @Bean
    public Docket createRestApi (){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(HelloWorldController.class.getPackage().getName()))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * http://localhost:8080/swagger-ui.html
     * @return
     */
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("swagger测试")
                .description("swagger测试详情")
//                .contact(new Contact("xuweiwei", "sadhh", "email"))
//                .license("license")
//                .licenseUrl("adjwj")
                .termsOfServiceUrl("www.baidu.com")
                .version("1.0")
                .build();
    }
}