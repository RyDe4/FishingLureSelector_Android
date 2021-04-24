package com.example.fishinglureselector;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class PreferenceDataEntry {
    @PrimaryKey
    public int prefId;

    public int species;

    public int prefLure;

    public double prefStrength;

    public int tempCondition;

    public int lightCondition;

    public int spotId;
}
