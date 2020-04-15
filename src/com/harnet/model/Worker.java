package com.harnet.model;
import java.util.concurrent.ThreadLocalRandom;

public class Worker extends Ant {

    public Worker(String name, int[] initialPosition) {
        super(name, initialPosition);
    }

//    @Override
//    public void move() {
//        Colony colony = Colony.getInstance();
//        int[] currentPosition = this.getPosition();
//        int[] newPosition = behaviour();
////        int x = this.getPosition()[0] + ThreadLocalRandom.current().nextInt(-1, 1 + 1);
////        int y = this.getPosition()[1] + ThreadLocalRandom.current().nextInt(-1, 1 + 1);
////        int[] newPosition = new int[]{x,y};
//        // check if the move out of bound
//        for(Ant ant : Colony.getInstance().getAnts()){
//            // todo divide to specific method isInBounds
//            if(colony.isInColonyBounds(newPosition)&&
//                    ant.getAntByPosition(currentPosition) != null && ant.getAntByPosition(newPosition) == null){
//                ant.setPosition(newPosition);
//            }
//        }
//    }

    @Override
    public int[] behaviour(){
        int x = this.getPosition()[0] + ThreadLocalRandom.current().nextInt(-1, 1 + 1);
        int y = this.getPosition()[1] + ThreadLocalRandom.current().nextInt(-1, 1 + 1);
        return new int[]{x,y};
    }
}