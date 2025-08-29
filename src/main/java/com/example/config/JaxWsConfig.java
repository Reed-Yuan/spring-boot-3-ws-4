package com.example.config;

import com.example.service.UserService;
import com.sun.xml.ws.transport.http.servlet.WSServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
public class JaxWsConfig {

    @Bean
    public ServletRegistrationBean<WSServlet> wsServlet() {
        ServletRegistrationBean<WSServlet> registration = new ServletRegistrationBean<>();
        registration.setServlet(new WSServlet());
        registration.addUrlMappings("/ws/*");
        registration.setName("ws");
        return registration;
    }

    @Bean
    public UserService userService() {
        return new UserService();
    }
}
