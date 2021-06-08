package com.example.fishinglureselector;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class FishRepository {

    //the DAO
    private FishDbAccessor dbAccessor;

    private LiveData<List<SpotDataEntry>> spots;

    FishRepository (Application application) {
        FishDatabase db = FishDatabase.getDatabase(application);
        this.dbAccessor = db.dbAccessor();
        this.spots = dbAccessor.getAllSpots();
    }

    LiveData<List<SpotDataEntry>> getSpots() {
        return this.spots;
    }

    public void insert(SpotDataEntry spot) {
        new insertAsyncTask(dbAccessor).execute(spot);
    }

    private static class insertAsyncTask extends AsyncTask<SpotDataEntry, Void, Void> {

        private FishDbAccessor mAsyncTaskDao;

        insertAsyncTask(FishDbAccessor dbAccessor) {
            mAsyncTaskDao = dbAccessor;
        }

        @Override
        protected Void doInBackground(final SpotDataEntry... params) {
            mAsyncTaskDao.insertSpot(params[0]);
            return null;
        }
    }
}
