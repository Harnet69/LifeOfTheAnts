package com.harnet.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Colony {
    private static Colony colony = null;
    private final static List<Integer> COLONYSIZE = Arrays.asList(100, 100);
    private List<Ant> ants = new ArrayList<>();

    private Colony() {
        populateColony();
    }

    public List<Integer> getCOLONYSIZE() {
        return COLONYSIZE;
    }

    public static Colony getColony() {
        if(colony == null){
            colony = new Colony();
        }
        return colony;
    }

    private void populateColony(){
        ants.add(Queen.getInstance());
        ants.add(new Soldier());
        ants.add(new Worker());
        ants.add(new Drone());
    }

    public List<Ant> getAnts() {
        return ants;
    }
}
