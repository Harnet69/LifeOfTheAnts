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
        List<Integer> currentPosition = Arrays.asList(this.getPosition().get(0), this.getPosition().get(1));
        int x = this.getPosition().get(0) + ThreadLocalRandom.current().nextInt(-1, 1 + 1);
        int y = this.getPosition().get(1) + ThreadLocalRandom.current().nextInt(-1, 1 + 1);

        // check if the move out of bound
        for(Ant ant : Colony.getInstance().getAnts()){
            if(x >= 0 && y >= 0 && x <= Colony.COLONY_SIZE.get(0) && y <= Colony.COLONY_SIZE.get(1) &&
                    ant.getAntByPosition(currentPosition) != null){
                return Arrays.asList(x,y);
            }
        }
        System.out.println("out of bounds");
        return currentPosition;
    }
}