package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class ConcatService {
    public String concat(String name) {
        return name + " is awesome!";
    }
}
