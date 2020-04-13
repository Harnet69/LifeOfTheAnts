package com.harnet.model;

public class Queen extends Ant {


    private Queen(String name, int[] position) {
        super(name, position);
    }



    @Override
    public int[] move() {
        return new int[0];
    }
}
