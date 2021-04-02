package com.example.hibernate.person;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "personsHibernate")
public class PersonWithSpringHibernate {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String address;
    private int age;


    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    public String getAddress() {return address;}
    public void setAddress(String address){ this.address = address;}

    public int getAge() {return age;};
    public void setAge(int age) {this.age = age;}

}
