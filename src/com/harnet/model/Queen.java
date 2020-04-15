package com.harnet.model;

public class Queen extends Ant {
    private static Queen instance = null;

    private Queen(String name, int[] initialPosition) {
        super(name, initialPosition);
    }

    public static Queen getInstance(){
        if(instance == null){
            instance = new Queen("queen", new int[]{5, 5});
        }
        return instance;
    }

    @Override
    public void move() {}
}
