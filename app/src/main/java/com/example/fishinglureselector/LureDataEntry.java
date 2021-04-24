package com.example.fishinglureselector;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class LureDataEntry {
    @PrimaryKey
    public String name;

    public String type;

    public String colour;

    public String reflectivity;

    public boolean scent;

    public boolean depth;
}
