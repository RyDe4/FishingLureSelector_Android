package com.example.fishinglureselector;

import android.app.Application;

import androidx.room.Room;

public class FishingLureSelector extends Application {
    public FishDatabase db = Room.databaseBuilder(getApplicationContext(),
            FishDatabase.class, "FishDatabase").build();
}
