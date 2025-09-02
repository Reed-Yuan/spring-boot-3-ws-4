package com.example.service;

import jakarta.annotation.PostConstruct;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@WebService(endpointInterface = "com.example.service.GreetingService")
@Service
public class GreetingServiceImpl implements GreetingService {

    private ConcatService concatService;

    public GreetingServiceImpl() {
    }

    @Autowired
    public GreetingServiceImpl(ConcatService concatService) {
        this.concatService = concatService;
    }

    @Override
    public String sayHello(String name) {
        return "Hello, " + this.concatService.concat(name);
    }

    @PostConstruct
    public void init() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }
}
