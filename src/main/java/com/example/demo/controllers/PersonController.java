package com.example.demo.controllers;

import com.example.demo.DatabaseConnection;
import com.example.demo.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class PersonController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/person")
    public Person person(){
        return new Person("Muhidin", "Hukic", 25, "677 S River Rd", counter.incrementAndGet());
    }

    @GetMapping("/persons")
    public ArrayList<Object> persons() throws ClassNotFoundException {
        return new ArrayList<Object>(DatabaseConnection.ConnectionToPersonsTable());
    }
}
