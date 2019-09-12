package com.turing.website.config;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.server.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Meng
 * @date 2019/9/3
 */
@Configuration
public class ErrorPageConfiguration{
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer() {
        return (factory->{
            Set<ErrorPage> errorPageSet=new HashSet<>();
            errorPageSet.add(new ErrorPage(HttpStatus.NOT_FOUND,"/404.html"));
            errorPageSet.add(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/500.html"));
            factory.setErrorPages(errorPageSet);
        });
    }
}
