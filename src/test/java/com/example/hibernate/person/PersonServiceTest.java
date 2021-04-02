package com.example.hibernate.person;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class PersonServiceTest {

    @Autowired
    private PersonService personService;

    public void whenApplicationStarts_HibernateCreatesInitialRecords(){
        List<PersonWithSpringHibernate> persons = personService.list();

        assertEquals(persons.size(), 0);
    }
}