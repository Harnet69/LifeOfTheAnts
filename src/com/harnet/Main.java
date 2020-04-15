package com.harnet;

import com.harnet.model.Ant;
import com.harnet.model.AntSpecie;
import com.harnet.model.Colony;

import java.util.Arrays;

public class Main {
    private static final int ITERATIONS_QTT = 10;

    public static void main(String[] args) {
        //size of the colony
        System.out.println("Size of the colony: ");
        System.out.println(Arrays.toString(Colony.getInstance().getCOLONYSIZE()));

        //Show all ants with coordinates
        System.out.println();
        System.out.println("Ants with initial coordinates: ");
        for(Ant ant : Colony.getInstance().getAnts()){
            System.out.println(ant.getName() + " : " + Arrays.toString(ant.getPosition()));
        }

        // number of drones in the colony
        System.out.println();
        System.out.println("Drones in the colony: ");
        System.out.println(Colony.getInstance().countAnts(AntSpecie.DRONE.toString()));

        // move ants
        System.out.println();
        System.out.println("Movement of some ant: ");
        for(int i=0; i<ITERATIONS_QTT; i++) {
            for(Ant ant : Colony.getInstance().getAnts()){
                ant.move();
            }

            System.out.print(Colony.getInstance().getAnts().get(5).getName() + ":"
                    + Arrays.toString(Colony.getInstance().getAnts().get(5).getPosition()));
            if(i < ITERATIONS_QTT-1) {
                System.out.print(" -> ");
            }
        }

        // Get the ant by its position
        System.out.println();
        System.out.println("Queen of ant on position: ");
        System.out.println(Colony.getInstance().getAntByPosition(new int[]{5,5}));
    }
}