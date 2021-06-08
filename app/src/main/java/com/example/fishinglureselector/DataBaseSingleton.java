package com.example.fishinglureselector;

public class DataBaseSingleton {
    private static FishDatabase fishDb = null;

    public DataBaseSingleton(){}

    public void setFishDb(FishDatabase fishDb) {
        DataBaseSingleton.fishDb = fishDb;
    }

    public FishDatabase getFishDb() {
        return DataBaseSingleton.fishDb;
    }
}
