package com.harnet.model;

import java.util.Arrays;

public class Soldier extends Ant {
    private int moveCounter = 1;

    public Soldier(String name, int[] initialPosition) {
        super(name, initialPosition);
    }

    @Override
    public int[] behaviour() {
        int x = this.getPosition()[0];
        int y = this.getPosition()[1];
        switch (moveCounter) {
            case 1:
                moveCounter++;
                return new int[]{x + 1, y};
            case 2:
                moveCounter++;
                return new int[]{x, y + 1};
            case 3:
                moveCounter++;
                return new int[]{x - 1, y};
            case 4:
                moveCounter = 1;
                return new int[]{x, y - 1};
            default:
                throw new IllegalStateException("Unexpected value: " + moveCounter);
        }
    }
}
