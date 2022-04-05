package com.avbravo.templatefaces.services;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HelloService {

    public String createHello(String name) {
        return "Hello " + name;
    }

}
