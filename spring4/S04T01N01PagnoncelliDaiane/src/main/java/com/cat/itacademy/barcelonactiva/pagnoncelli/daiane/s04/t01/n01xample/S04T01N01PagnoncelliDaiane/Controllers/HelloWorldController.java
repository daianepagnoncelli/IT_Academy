package com.cat.itacademy.barcelonactiva.pagnoncelli.daiane.s04.t01.n01xample.S04T01N01PagnoncelliDaiane.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/HelloWorld")
    public String greetings(@RequestParam(defaultValue = "UNKNOWN") String name) {
        return "Hello, " + name + ". You are running a Maven project";
    }

    @GetMapping({"/HelloWorld2", "/HelloWorld2/{name}"})
    public String greetings2(@PathVariable(required = false) String name) {
        if (name == null) {
            name = "UNKNOWN";
        }
        return "Hello, " + name + ". You are running a Maven project";
    }
}


