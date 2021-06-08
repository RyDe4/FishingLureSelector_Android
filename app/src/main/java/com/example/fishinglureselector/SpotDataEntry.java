package com.example.fishinglureselector;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class SpotDataEntry {
    @PrimaryKey
    @NonNull
    public String spotName;

    public int typeCode;

    public int size;

    public int bottom;
}
