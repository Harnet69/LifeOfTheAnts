package com.harnet.model;
import java.util.concurrent.ThreadLocalRandom;

public class Worker extends Ant {

    public Worker(String name, int[] initialPosition) {
        super(name, initialPosition);
    }

    @Override
    public int[] behaviour(){
        int x = this.getPosition()[0] + ThreadLocalRandom.current().nextInt(-1, 1 + 1);
        int y = this.getPosition()[1] + ThreadLocalRandom.current().nextInt(-1, 1 + 1);
        return new int[]{x,y};
    }
}