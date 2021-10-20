package com.company;

public class Cat {
    private String name;
    private String age;
    private Master master;

    public Cat() {
    }

    public Cat(String name, String age, Master master) {
        this.name = name;
        this.age = age;
        this.master = master;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }
}
