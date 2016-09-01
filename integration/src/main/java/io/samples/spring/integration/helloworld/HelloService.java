package io.samples.spring.integration.helloworld;

import org.springframework.stereotype.Component;

@Component
public class HelloService {
    public String say(String message) {
        return "Hello, " + message;
    }
}
