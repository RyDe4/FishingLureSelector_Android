package com.example.fishinglureselector;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ForeignKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity
public class PreferenceDataEntry {
    @PrimaryKey
    public int prefId;

    @ForeignKey(entity = PreferenceDataEntry.class, parentColumns = "speciesName",
    childColumns = "species", onDelete = CASCADE)
    public int species;

    public int prefLure;

    public double prefStrength;

    public int tempCondition;

    public int lightCondition;

    public int spotId;
}
