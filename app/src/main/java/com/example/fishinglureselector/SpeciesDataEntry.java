package com.example.fishinglureselector;

import androidx.annotation.NonNull;
import androidx.room.Entity;


@Entity(primaryKeys = {"speciesName", "preference"})
public class SpeciesDataEntry {

    @NonNull
    public String speciesName;

    @NonNull
    public int preference;
}
