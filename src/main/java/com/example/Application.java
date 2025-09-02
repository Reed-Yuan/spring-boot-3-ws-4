package com.example;

import com.example.service.GreetingService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example")
public class Application extends SpringBootServletInitializer {

    @Autowired
    private Bus cxfBus;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ServletRegistrationBean<CXFServlet> cxfServlet() {
        return new ServletRegistrationBean<>(new CXFServlet(), "/ws/*");
    }

    @Bean
    public JaxWsServerFactoryBean greetingService(GreetingService greetingService) {
        JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
        factory.setBus(cxfBus);
        factory.setServiceClass(GreetingService.class);
        factory.setAddress("/greeting");
        factory.setServiceBean(greetingService);
        factory.create();
        return factory;
    }
}
