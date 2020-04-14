package com.harnet.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Colony {
    private static Colony instance = null;
    public final static List<Integer> COLONY_SIZE = Arrays.asList(10, 10);
    private final int WORKERS_QTT = 4;
    private final int SOLDIERS_QTT = 3;
    private final int DRONES_QTT = 2;
    private List<Ant> ants = new ArrayList<>();

    private Colony() {
        populateColony();
    }

    public List<Integer> getCOLONYSIZE() {
        return COLONY_SIZE;
    }

    public static Colony getInstance() {
        if(instance == null){
            instance = new Colony();
        }
        return instance;
    }

    public List<Ant> getAnts() {
        return ants;
    }

    private void populateColony(){
       populateWith(1, "Queen");
       populateWith(WORKERS_QTT, "worker");
       populateWith(SOLDIERS_QTT, "soldier");
       populateWith(DRONES_QTT, "drone");
    }

    private void populateWith(int qtt, String antName){
        for(int i=1; i<=qtt; i++){
            Ant ant = null;
            switch (antName) {
                case "Queen": ant = Queen.getInstance();
                                break;
                case "worker":  ant = new Worker();
                                break;
                case "soldier": ant = new Soldier();
                                break;
                case "drone":   ant = new Drone();
                                break;
            }
            if(isCoordinateUnique(ant, ants)){
                ants.add(ant);
            }else{
                i--;
            }
        }
    }

    // check if the coordinate empty
    public boolean isCoordinateUnique(Ant ant, List<Ant> ants){
        for(Ant antInAnts : ants){
            assert ant != null;

            if(antInAnts.getPosition().get(0).equals(ant.getPosition().get(0)) &&
                    antInAnts.getPosition().get(1).equals(ant.getPosition().get(1))){
                System.out.println("Coordinate isn't unique");
                return false;
            }
        }
        return true;
    }

    //count the quantity of specific ant
    public int countAnts(String antName){
        return ants.stream()
                .filter(x -> x.getName()
                .equals(antName))
                .map(e -> 1)
                .reduce(0, Integer::sum);
    }
}
