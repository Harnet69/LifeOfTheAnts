package com.harnet.model;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Worker extends Ant {

    public Worker() {
        super("worker");
    }

    @Override
    public List<Integer> move() {
        int x = this.getPosition().get(0) + ThreadLocalRandom.current().nextInt(-1, 1 + 1);
        int y = this.getPosition().get(1) + ThreadLocalRandom.current().nextInt(-1, 1 + 1);

        return Arrays.asList(x,y);
    }
}
