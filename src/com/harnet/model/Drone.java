package com.harnet.model;

public class Drone extends Ant {

    public Drone(String name, int[] initialPosition) {
        super(name, initialPosition);
    }

    @Override
    public void move(){}

    @Override
    public int[] behaviour() {
        return new int[0];
    }
}
