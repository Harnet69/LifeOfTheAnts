package com.harnet.model;

public class Colony {
    private static Colony colony = null;

    private Colony() {
    }

    public static Colony getColony() {
        if(colony == null){
            colony = new Colony();
        }
        return colony;
    }
}
