package com.harnet;

import com.harnet.model.Ant;
import com.harnet.model.Colony;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println(Colony.getColony().getCOLONYSIZE());
        List<Ant> ants = Colony.getColony().getAnts();
        for(Ant ant : ants){
            System.out.println(ant.getName() + " : " + ant.getPosition());
        }
    }
}
