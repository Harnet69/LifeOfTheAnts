package com.harnet.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static com.harnet.model.AntSpecie.*;

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
        if (instance == null) {
            instance = new Colony();
        }
        return instance;
    }

    public List<Ant> getAnts() {
        return ants;
    }

    public List<Integer> setInitialPosition() {
        Random rn = new Random();
        return Arrays.asList(rn.nextInt(COLONY_SIZE.get(0)), rn.nextInt(COLONY_SIZE.get(1)));
    }

    private void populateColony() {
        populateWith(1, QUEEN);
        populateWith(WORKERS_QTT, WORKER);
        populateWith(SOLDIERS_QTT, SOLDIER);
        populateWith(DRONES_QTT, DRONE);
    }

    //TODO move set initial coordinates here
    // - fresh born ant get initial position here
    // - replaced string in a ant name with ENUM
    private void populateWith(int qtt, AntSpecie antName) {
        for (int i = 1; i <= qtt; i++) {
            Ant ant = null;
            switch (antName) {
                case QUEEN:
                    ant = Queen.getInstance();
                    break;
                case WORKER:
                    ant = new Worker(WORKER.toString(), setInitialPosition());
                    break;
                case SOLDIER:
                    ant = new Soldier(SOLDIER.toString(), setInitialPosition());
                    break;
                case DRONE:
                    ant = new Drone(DRONE.toString(), setInitialPosition());
                    break;
            }
            if (isCoordinateUnique(ant, ants)) {
                ants.add(ant);
            } else {
                i--;
            }
        }
    }

    // check if the coordinate empty
    public boolean isCoordinateUnique(Ant ant, List<Ant> ants) {
        for (Ant antInAnts : ants) {
            assert ant != null;

            if (antInAnts.getPosition().get(0).equals(ant.getPosition().get(0)) &&
                    antInAnts.getPosition().get(1).equals(ant.getPosition().get(1))) {
                System.out.println("Coordinate isn't unique");
                return false;
            }
        }
        return true;
    }

    //count the quantity of specific ant
    public int countAnts(String antName) {
        return ants.stream()
                .filter(x -> x.getName()
                        .equals(antName))
                .map(e -> 1)
                .reduce(0, Integer::sum);
    }
}
