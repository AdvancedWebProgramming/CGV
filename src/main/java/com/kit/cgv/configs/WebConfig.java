package com.kit.cgv.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry){
       registry.addMapping("/**")
               .allowedOrigins("*")
               .allowedMethods("*");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/public/static/images/**")
                .addResourceLocations("file:///" + "C:/Users/khj74/IdeaProjects/CGV/src/main/resources/public/static/images/");
    }
}
