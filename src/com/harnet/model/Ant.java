package com.harnet.model;

public abstract class Ant {
    private final String name;
    // TODO Change ArrayList to int[]
    private int[] position; // Change ArrayList to int[]

    public Ant(String name, int[] initialPosition) {
        this.name = name;
        this.position = initialPosition;
    }

    public String getName() {
        return name;
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public Ant getAntByPosition(int[] position){
        if(this.position[0] == position[0] && this.position[1] == position[1]){
            return this;
        }
        return null;
    }

    public abstract void move();
}
