package com.harnet.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Colony {
    private static Colony colony = null;
    public final static List<Integer> COLONYSIZE = Arrays.asList(10, 10);
    private final int WORKERS_QTT = 10;
    private final int SOLDIERS_QTT = 5;
    private final int DRONES_QTT = 3;
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

//            for(Ant antInAnts : ants){
//                assert ant != null;
//
//                if(antInAnts.getPosition().get(0).equals(ant.getPosition().get(0)) &&
//                        antInAnts.getPosition().get(1).equals(ant.getPosition().get(1))){
//                    System.out.println("Coordinate isn't unique");
////                System.out.print(antInAnts.getPosition() + " : ");
////                assert ant != null;
////                System.out.println(ant.getPosition());
//                }
//            }
//                    ants.add(ant);


//            Ant finalAnt = ant;
//            ants.stream()
//                    .map(x -> x.getPosition().get(0).equals(finalAnt.getPosition().get(0)) && x.getPosition().get(1).equals(finalAnt.getPosition().get(1)) )
//                    .forEach(System.out::println);

//            System.out.println(samePos);
        }
    }
    private boolean isCoordinateUnique(Ant ant, List<Ant> ants){
        for(Ant antInAnts : ants){
            assert ant != null;

            if(antInAnts.getPosition().get(0).equals(ant.getPosition().get(0)) &&
                    antInAnts.getPosition().get(1).equals(ant.getPosition().get(1))){
                System.out.println("Coordinate isn't unique");
//                System.out.print(antInAnts.getPosition() + " : ");
//                assert ant != null;
//                System.out.println(ant.getPosition());
                return false;
            }
        }
        return true;
    }

    public List<Ant> getAnts() {
        return ants;
    }
}
