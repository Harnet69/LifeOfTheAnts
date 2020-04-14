package com.harnet.model;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public abstract class Ant {
    private final String name;
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

    public void setPosition(List<Integer> position) {
        this.position = position;
    }

    public List<Integer> setInitialPosition() {
        Random rn = new Random();
        return Arrays.asList(rn.nextInt(Colony.COLONY_SIZE.get(0)), rn.nextInt(Colony.COLONY_SIZE.get(1)));
    }

    public Ant getAntByPosition(List<Integer> position){
        if(this.position.get(0).equals(position.get(0)) && this.position.get(1).equals(position.get(1))){
            return this;
        }
        return null;
    }

    public abstract List<Integer> move();
}
