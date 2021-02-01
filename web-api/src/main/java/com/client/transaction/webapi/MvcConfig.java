package com.client.transaction.webapi;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

@Configuration
@EnableWebMvc
@EnableSwagger2
public class MvcConfig implements WebMvcConfigurer {
    private static final String dateFormat = "yyyy-MM-dd";
    private static final String dateTimeFormat = "yyyy-MM-dd HH:mm:ss";

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowCredentials(true).maxAge(3600);
    }

    @Bean
    public InternalResourceViewResolver defaultViewResolver() {
        return new InternalResourceViewResolver();
    }

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jacksonObjectMapperCustomization() {
        return jacksonObjectMapperBuilder -> {
            jacksonObjectMapperBuilder.simpleDateFormat(dateTimeFormat);
            jacksonObjectMapperBuilder.serializers(new LocalDateSerializer(DateTimeFormatter.ofPattern(dateFormat)));
            jacksonObjectMapperBuilder.serializers(new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(dateTimeFormat)));
            jacksonObjectMapperBuilder.timeZone(TimeZone.getDefault());
        };
    }
}
