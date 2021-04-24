package com.example.fishinglureselector;

import androidx.room.Entity;


@Entity(primaryKeys = {"speciesName", "preference"})
public class SpeciesDataEntry {

    public String speciesName;

    public int preference;
}
