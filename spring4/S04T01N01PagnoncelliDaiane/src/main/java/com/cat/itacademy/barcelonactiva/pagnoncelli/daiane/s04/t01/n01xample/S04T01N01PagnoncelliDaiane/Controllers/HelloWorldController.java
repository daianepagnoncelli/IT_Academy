package com.cat.itacademy.barcelonactiva.pagnoncelli.daiane.s04.t01.n01xample.S04T01N01PagnoncelliDaiane.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private static final String DEFAULT_NAME = "UNKNOWN";
    private static final String RESPONSE_TEMPLATE = "Hello, %s. You are running a Maven project";

    @GetMapping("/HelloWorld")
    public String greetWithRequestParam(@RequestParam(defaultValue = DEFAULT_NAME) String name) {
        return formatGreeting(name);
    }

    @GetMapping("/HelloWorld/{name}")
    public String greetWithPathVariable(@PathVariable String name) {
        return formatGreeting(name);
    }

    private String formatGreeting(String name) {
        return String.format(RESPONSE_TEMPLATE, name);
    }
}
