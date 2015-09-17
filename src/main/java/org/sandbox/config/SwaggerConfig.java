package org.sandbox.config;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.models.dto.builder.ApiInfoBuilder;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.inject.Inject;

/**
 * Author: zhangxin
 * Date:   15-9-17
 */
@Configuration
@EnableSwagger
public class SwaggerConfig {

    @Inject
    private SpringSwaggerConfig springSwaggerConfig;

    private ApiInfo getApiInfo() {

        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("Spring Boot Example API")
                .description("Spring Boot Example API")
                .termsOfServiceUrl("http://example.com/terms-of-service")
                .contact("info@example.com")
                .license("MIT License")
                .licenseUrl("http://opensource.org/licenses/MIT")
                .build();

        return apiInfo;
    }

    @Bean
    public SwaggerSpringMvcPlugin apiConfiguration() {
        SwaggerSpringMvcPlugin swaggerSpringMvcPlugin = new SwaggerSpringMvcPlugin(this.springSwaggerConfig);
        swaggerSpringMvcPlugin
                .apiInfo(getApiInfo()).apiVersion("0.1")
                .includePatterns("/demo/v1/persons/*.*").swaggerGroup("v1");
        swaggerSpringMvcPlugin.useDefaultResponseMessages(false);
        return swaggerSpringMvcPlugin;
    }
}
