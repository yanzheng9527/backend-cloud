package com.randy.backend.model;

public class Person extends Entity{
    private static final long serialVersionUID = 1L;
    private String name;
    private Integer age;

    public Person() {
        super();
    }

    public Person(String id, String name, Integer age) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
