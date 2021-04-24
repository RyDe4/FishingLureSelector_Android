package com.example.fishinglureselector;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CatchDataEntry {
    @PrimaryKey
    public int catchId;

    public int spotId;

    public int speciesId;

    public int lureId;

    public int lightCondition;

    public int thermalCondition;

    public boolean structureCondition;

    public int spotType;

    public int spotSize;

    public int spotBottom;
}
