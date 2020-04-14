package com.harnet;

import com.harnet.model.Ant;
import com.harnet.model.Colony;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        //size of the colony
        System.out.println("size of the colony");
        System.out.println(Colony.getInstance().getCOLONYSIZE());

        //Show all ants with coordinates
        for(Ant ant : Colony.getInstance().getAnts()){
            System.out.println(ant.getName() + " : " + ant.getPosition());
        }

        // number of drones in the colony
        System.out.println();
        System.out.println("Drones in the colony");
        System.out.println(Colony.getInstance().countAnts("drone"));

        // move ants
        Colony.getInstance().getAnts().stream()
                .filter(x -> x.getName().equals("worker"))
                .map(Ant::move)
                .forEach(System.out::println);
    }
}
