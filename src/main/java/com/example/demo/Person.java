package com.example.demo;

public class Person {

    private final String firstName;
    private final String lastName;
    private final int age;
    private final String address;
    private final long id;

    public Person(String firstName, String lastName, int age, String address, long id) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.age = age;

    }

    public int getAge() {
        return age;
    }

    public long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }




}
