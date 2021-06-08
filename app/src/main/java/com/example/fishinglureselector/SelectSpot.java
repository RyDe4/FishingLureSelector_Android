package com.example.fishinglureselector;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SelectSpot extends AppCompatActivity {

    private SelectSpotViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_spot);
        model = new SelectSpotViewModel(getApplication());
        buildButtonsFromDb();
    }


    public void newSpotButtonOnClick(View view) {
        Intent intent = new Intent(SelectSpot.this, NewSpot.class);
        startActivity(intent);
    }


    private void buildButtonsFromDb() {
        /*Create a button for each spot in the database and add it to the linear layout view*/
        LiveData<List<SpotDataEntry>> spotsData = model.getAllSpots();
        List<SpotDataEntry> spots = spotsData.getValue();

        model.getAllSpots().observe(this, new Observer<List<SpotDataEntry>>() {
            @Override
            public void onChanged(@Nullable final List<SpotDataEntry> spots) {
                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.spot_lin_layout);
                if (spots != null) {
                    int len = spots.size();
                    for (int i = 0; i < len; i++) {
                        Button btnTag = new Button(SelectSpot.this);
                        btnTag.setLayoutParams(new LinearLayout.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT,
                                ActionBar.LayoutParams.WRAP_CONTENT));
                        btnTag.setText(spots.get(i).spotName);
                        linearLayout.addView(btnTag);
                    }
                }
            }
        });


    }

}