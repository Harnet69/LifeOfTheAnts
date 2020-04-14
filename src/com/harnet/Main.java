package com.harnet;

import com.harnet.model.Ant;
import com.harnet.model.Colony;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        //size of the colony
        System.out.println("size of the colony");
        System.out.println(Colony.getInstance().getCOLONYSIZE());

        List<Ant> ants = Colony.getInstance().getAnts();
        for(Ant ant : ants){
//            System.out.println(ant.getName() + " : " + ant.getPosition());
        }
        // number of drones in the colony
        System.out.println();
        System.out.println(Colony.getInstance().countAnts("drone"));

        ants.stream()
                .filter(x -> x.getName().equals("worker"))
                .map(x -> x.move())
                .forEach(System.out::println);
    }
}
