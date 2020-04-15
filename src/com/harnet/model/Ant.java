package com.harnet.model;

public abstract class Ant {
    private final String name;
    // TODO Change ArrayList to int[]
    private int[] position; // Change ArrayList to int[]

    public Ant(String name, int[] initialPosition) {
        this.name = name;
        this.position = initialPosition;
    }

    public String getName() {
        return name;
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public Ant getAntByPosition(int[] position){
        if(this.position[0] == position[0] && this.position[1] == position[1]){
            return this;
        }
        return null;
    }

//    public abstract void move();

    public void move() {
        Colony colony = Colony.getInstance();
        int[] currentPosition = this.getPosition();
        int[] newPosition = behaviour();
//        int x = this.getPosition()[0] + ThreadLocalRandom.current().nextInt(-1, 1 + 1);
//        int y = this.getPosition()[1] + ThreadLocalRandom.current().nextInt(-1, 1 + 1);
//        int[] newPosition = new int[]{x,y};
        // check if the move out of bound
        for(Ant ant : Colony.getInstance().getAnts()){
            // todo divide to specific method isInBounds
            if(colony.isInColonyBounds(newPosition)&&
                    ant.getAntByPosition(currentPosition) != null && ant.getAntByPosition(newPosition) == null){
                ant.setPosition(newPosition);
            }
        }
    }

    public abstract int[] behaviour();
}
