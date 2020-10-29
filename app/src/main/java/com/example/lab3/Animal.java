package com.example.lab3;

public class Animal {
    private String name;
    private String group;
    private boolean isPredator;
    private boolean isFlying;



    public Animal(String name, String group, boolean isPredator, boolean isFlying) {
        this.name = name;
        this.group = group;
        this.isPredator = isPredator;
        this.isFlying = isFlying;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public boolean isFlying() {
        return isFlying;
    }

    public boolean isPredator() {
        return isPredator;
    }
}
