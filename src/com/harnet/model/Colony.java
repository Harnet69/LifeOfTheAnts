package com.harnet.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.harnet.model.AntSpecie.*;

public class Colony {
    private static Colony instance = null;
    public final static int[] COLONY_SIZE = new int[] {10,10};
    private final int WORKERS_QTT = 4;
    private final int SOLDIERS_QTT = 3;
    private final int DRONES_QTT = 2;
    private List<Ant> ants = new ArrayList<>();

    private Colony() {
        populateColony();
    }

    public int[] getCOLONYSIZE() {
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

    public int[] setInitialPosition() {
        Random rn = new Random();
        return new int[]{rn.nextInt(COLONY_SIZE[0]), rn.nextInt(COLONY_SIZE[1])};
    }

    private void populateColony() {
        populateWith(1, QUEEN);
        populateWith(WORKERS_QTT, WORKER);
        populateWith(SOLDIERS_QTT, SOLDIER);
        populateWith(DRONES_QTT, DRONE);
    }

    //TODO move set initial coordinates here
    // - fresh born ant get initial position here
    // - replaced string in a ant's name with ENUM
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

            if (antInAnts.getPosition()[0] == ant.getPosition()[0] &&
                    antInAnts.getPosition()[1] == ant.getPosition()[1]) {
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

    // Get the ant by its position
    public Ant getAntByPosition(int[] pos) {
        for(Ant ant : ants){
            if (ant.getPosition()[0] == pos[0] && ant.getPosition()[1] == pos[1]){
                return ant;
            }
        }
        return null;
    }


    // Get the ant by its position with Streams
//    public Ant getAntByPosition(List<Integer> pos) {
//        List<Ant> antByPos = null;
//        try {
//            antByPos = ants.stream()
//                    .filter(x -> x.getPosition().equals(pos))
//                    .collect(Collectors.toList());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        assert antByPos != null;
//        if (antByPos.size() > 0) {
//            return antByPos.get(0);
//        } else {
//            return null;
//        }
//    }

    // TODO create method coordinates-out-of-colony-bounds
    // check is the coordinates out of Colony boundaries
    public boolean isInColonyBounds(int[] coordinates) {
        return coordinates[0] >= 0 && coordinates[1] >= 0
                && coordinates[0] <= Colony.COLONY_SIZE[0]
                && coordinates[1] <= Colony.COLONY_SIZE[1];
    }
}