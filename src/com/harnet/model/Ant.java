package com.harnet.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public abstract class Ant {
    private String name;
    private List<Integer> position;

    public Ant(String name) {
        this.name = name;
        this.position = setInitialPosition();
    }

    public String getName() {
        return name;
    }

    public List<Integer> getPosition() {
        return position;
    }

    public List<Integer> setInitialPosition() {
        Random rn = new Random();
        return Arrays.asList(rn.nextInt(100), rn.nextInt(100));
    }

    public abstract List<Integer> move();
}
