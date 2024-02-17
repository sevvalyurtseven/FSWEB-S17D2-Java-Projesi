package com.workintech.s17g2.model;

public class Developer {
    private Integer id;
    private String name;
    private Double salary;
    private Experience experience;

    public Developer(Integer id, String name, Double salary, Experience experience) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.experience = experience;
    }
}
