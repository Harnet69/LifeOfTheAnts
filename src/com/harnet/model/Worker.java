package com.harnet.model;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class Worker extends Ant {

    public Worker(String name, List<Integer> initialPosition) {
        super(name, initialPosition);
    }

    @Override
    public void move() {
        Colony colony = Colony.getInstance();
        List<Integer> currentPosition = this.getPosition();
        int x = this.getPosition().get(0) + ThreadLocalRandom.current().nextInt(-1, 1 + 1);
        int y = this.getPosition().get(1) + ThreadLocalRandom.current().nextInt(-1, 1 + 1);
        List<Integer> newPosition = Arrays.asList(x,y);
        // check if the move out of bound
        for(Ant ant : Colony.getInstance().getAnts()){
            // todo divide to specific method isInBounds
            if(colony.isInColonyBounds(newPosition)&&
                    ant.getAntByPosition(currentPosition) != null && ant.getAntByPosition(newPosition) == null){
                ant.setPosition(newPosition);
            }
        }
    }
}