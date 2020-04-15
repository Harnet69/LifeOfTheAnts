package com.harnet;

import com.harnet.model.Ant;
import com.harnet.model.AntSpecie;
import com.harnet.model.Colony;

import java.util.Arrays;
import java.util.List;

public class Main {
    private static final int ITERATIONS_QTT = 10;

    public static void main(String[] args) {
        //size of the colony
        System.out.println("Size of the colony: ");
        System.out.println(Colony.getInstance().getCOLONYSIZE());

        //Show all ants with coordinates
        System.out.println();
        System.out.println("Ants with initial coordinates: ");
        for(Ant ant : Colony.getInstance().getAnts()){
            System.out.println(ant.getName() + " : " + ant.getPosition());
        }

        // number of drones in the colony
        System.out.println();
        System.out.println("Drones in the colony: ");
        System.out.println(Colony.getInstance().countAnts("drone"));

        // move ants
        System.out.println();
        System.out.println("Movement of some worker ant: ");
        for(int i=0; i<ITERATIONS_QTT; i++) {
            for(Ant ant : Colony.getInstance().getAnts()){
                ant.move();
            }

//            Colony.getInstance().getAnts().stream()
//                .filter(x -> x.getName().equals("worker"))
//                    .map(Ant::move);
////                    .forEach(System.out::println);

            // display movement of some ant
            System.out.print(Colony.getInstance().getAnts().get(2).getPosition());
            if(i < ITERATIONS_QTT-1) {
                System.out.print(" -> ");
            }
        }

        // Get the ant by its position
        System.out.println();
        System.out.println("Queen of ant on position: ");
        System.out.println(Colony.getInstance().getAntByPosition(Arrays.asList(5,5)));
    }
}
