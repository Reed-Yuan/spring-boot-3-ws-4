package com.example.service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public interface GreetingService {

    @WebMethod
    String sayHello(String name);
}
