package com.harnet.model;

import java.util.List;

public class Soldier extends Ant {


    public Soldier(String name, List<Integer> initialPosition) {
        super(name, initialPosition);
    }

    @Override
    public void move(){}
}
