package com.harnet.model;

import java.util.List;

public class Drone extends Ant {

    public Drone(String name, List<Integer> initialPosition) {
        super(name, initialPosition);
    }

    @Override
    public void move(){}
}
