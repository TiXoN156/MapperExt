package com.company;

public class Master {
    private String name;
    private Adress adress;
    private Job job;

    public Master() {
    }

    public Master(String name, Adress adress, Job job) {
        this.name = name;
        this.adress = adress;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
