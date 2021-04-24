package com.example.fishinglureselector;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class SpotDataEntry {
    @PrimaryKey
    public int spotId;

    public int typeCode;

    public int size;

    public int bottom;
}
