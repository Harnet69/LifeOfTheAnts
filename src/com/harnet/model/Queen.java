package com.harnet.model;

import java.util.Arrays;
import java.util.List;

public class Queen extends Ant {
    private static Queen instance = null;

    private Queen(String name, List<Integer> initialPosition) {
        super(name, initialPosition);
    }

    public static Queen getInstance(){
        if(instance == null){
            instance = new Queen("Queen", Arrays.asList(Colony.COLONY_SIZE.get(0)/2, Colony.COLONY_SIZE.get(1)/2));
        }
        return instance;
    }

    @Override
    public void move() {}
}
