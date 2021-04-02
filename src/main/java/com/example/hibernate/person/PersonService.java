package com.example.hibernate.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<PersonWithSpringHibernate> list() {
        return personRepository.findAll();
    }

}
