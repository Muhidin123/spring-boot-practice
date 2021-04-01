package com.example.demo.controllers;

import com.example.demo.DatabaseConnection;
import com.example.demo.Person;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class PersonController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/person")
    public Person person(){
        return new Person("Muhidin", "Hukic", 25, "677 S River Rd", counter.incrementAndGet());
    }


    //line 22 is unnecessary because of global application CORS setup in DemoApplication.java
    //If we do not want the global CORS Enabling then it is possible to do it this way
//  @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080"})
    @GetMapping("/persons") //maps the route to persons
    public ArrayList<Object> persons() throws ClassNotFoundException, SQLException {
        return new ArrayList<>(DatabaseConnection.ConnectionToPersonsTable());
    }

    //Creates new persons adds it to DB and returns new Person created as JSON
    @PostMapping(value = "/createPerson", consumes = "application/json", produces = "application/json")
    public Person  createPerson(@RequestBody Person person) throws SQLException {
        DatabaseConnection.updateTablePersons(person.getFirstName(),  person.getLastName(), person.getAddress(), person.getAge());
        return person;
    }
}

