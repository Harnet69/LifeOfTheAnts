package com.harnet.model;

import java.util.Arrays;
import java.util.List;

public class Queen extends Ant {
    private static Queen instance = null;

    private Queen(String name) {
        super(name);
    }

    public static Queen getInstance(){
        if(instance == null){
            instance = new Queen("Queen");
        }
        return instance;
    }

    public List<Integer> setInitialPosition() {
        return Arrays.asList(50, 50);
    }

    @Override
    public List<Integer> move() {
        return super.getPosition();
    }


}
