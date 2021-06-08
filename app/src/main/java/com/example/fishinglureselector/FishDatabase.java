package com.example.fishinglureselector;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {SpotDataEntry.class, PreferenceDataEntry.class,
        CatchDataEntry.class, SpeciesDataEntry.class, LureDataEntry.class}, version = 1,
        exportSchema = false)
public abstract class FishDatabase extends RoomDatabase {

    //the DAO
    public abstract FishDbAccessor dbAccessor();

    private static FishDatabase INSTANCE;

    static FishDatabase getDatabase (final Context context) {
        if (INSTANCE == null) {
            synchronized (FishDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context,
                            FishDatabase.class, "fish_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }

        return INSTANCE;
    }
}
