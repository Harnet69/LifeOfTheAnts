package com.harnet.model;

public abstract class Ant {
    private String name;
    private int[] position;

    public Ant(String name, int[] position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int[] getPosition() {
        return position;
    }

    public abstract int[] move();
}
