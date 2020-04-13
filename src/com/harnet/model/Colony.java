package com.harnet.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Colony {
    private static Colony colony = null;
    private final static List<Integer> COLONYSIZE = Arrays.asList(100, 100);
    private final int WORKERS_QTT = 20;
    private final int SOLDIERS_QTT = 10;
    private final int DRONES_QTT = 10;
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
       populateWith(1, "Queen");
       populateWith(WORKERS_QTT, "worker");
       populateWith(SOLDIERS_QTT, "soldier");
       populateWith(DRONES_QTT, "drone");
    }

    private void populateWith(int qtt, String antName){
        for(int i=1; i<=qtt; i++){
            switch (antName) {
                case "Queen":   ants.add(Queen.getInstance());
                case "worker":  ants.add(new Worker());
                case "soldier": ants.add(new Soldier());
                case "drone":   ants.add(new Drone());
            }
        }
    }

    public List<Ant> getAnts() {
        return ants;
    }
}
