package com.tohir153.travelEngine.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final GsonHttpMessageConverter gsonHttpMessageConverter;

    public WebConfig(GsonHttpMessageConverter gsonHttpMessageConverter) {
        this.gsonHttpMessageConverter = gsonHttpMessageConverter;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(gsonHttpMessageConverter);
    }
}
