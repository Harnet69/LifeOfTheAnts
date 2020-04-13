package com.harnet.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Ant {
    private String name;
    private List<Integer> position = new ArrayList<>();

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

    public abstract List<Integer> setInitialPosition();

    public abstract List<Integer> move();
}
