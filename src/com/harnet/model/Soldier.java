package com.harnet.model;

public class Soldier extends Ant {


    public Soldier(String name, int[] initialPosition) {
        super(name, initialPosition);
    }

    @Override
    public void move(){}

    @Override
    public int[] behaviour() {
        return new int[0];
    }
}
