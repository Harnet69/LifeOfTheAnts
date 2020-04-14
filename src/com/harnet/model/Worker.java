package com.harnet.model;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class Worker extends Ant {

    public Worker() {
        super("worker");
    }

    @Override
    public List<Integer> move() {
        // redundant
        List<Integer> currentPosition = this.getPosition();
        int x = this.getPosition().get(0) + ThreadLocalRandom.current().nextInt(-1, 1 + 1);
        int y = this.getPosition().get(1) + ThreadLocalRandom.current().nextInt(-1, 1 + 1);
        List<Integer> newPosition = Arrays.asList(x,y);
        // check if the move out of bound
        for(Ant ant : Colony.getInstance().getAnts()){
            // todo divide to specific method isInBounds
            if(x >= 0 && y >= 0 && x <= Colony.COLONY_SIZE.get(0) && y <= Colony.COLONY_SIZE.get(1) &&
                    ant.getAntByPosition(currentPosition) != null && ant.getAntByPosition(newPosition) == null){
                ant.setPosition(newPosition);
                return newPosition;
            }
        }
//        System.out.println("out of bounds");
        return currentPosition;
    }
}