package com.example.demo.controllers;

import java.util.concurrent.atomic.AtomicLong;

import com.example.demo.Greeting;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private Greeting greeting = new Greeting(1, "Muhidin");

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping
    //Function to test the 200 response
    public ResponseEntity<String> testResponse(){
        String  userDetails = greeting.getContent();
        return new ResponseEntity<>(userDetails, HttpStatus.OK);
    }

}
