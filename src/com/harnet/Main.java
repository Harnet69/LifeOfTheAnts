package com.harnet;

import com.harnet.model.Colony;

public class Main {

    public static void main(String[] args) {
        System.out.println(Colony.getColony().getCOLONYSIZE());
        System.out.println(Colony.getColony().getAnts().get(0).getPosition());
    }
}
