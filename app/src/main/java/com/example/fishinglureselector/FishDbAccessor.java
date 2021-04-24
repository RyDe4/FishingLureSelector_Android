package com.example.fishinglureselector;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface FishDbAccessor {

    @Query("SELECT * FROM SpeciesDataEntry WHERE speciesName = :speciesName")
    public List<SpeciesDataEntry> getSpeciesPrefs(String speciesName);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertCatch(CatchDataEntry ... catches);

    @Update
    public void updatePreference(PreferenceDataEntry ... preferences);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertLure(LureDataEntry ... lures);
}
