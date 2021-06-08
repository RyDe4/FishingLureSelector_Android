package com.example.fishinglureselector;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class SelectSpotViewModel extends AndroidViewModel {

    private FishRepository FishRepo;

    private LiveData<List<SpotDataEntry>> spotsLiveData;

    public SelectSpotViewModel(Application application) {
        super(application);
        this.FishRepo = new FishRepository(application);
        this.spotsLiveData = this.FishRepo.getSpots();
    }

    LiveData<List<SpotDataEntry>> getAllSpots() { return this.spotsLiveData; }

    public void insert(SpotDataEntry spot) { this.FishRepo.insert(spot); }
}
