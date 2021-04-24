package com.example.fishinglureselector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void viewLogsButtonOnClick(View view) {
        Intent intent = new Intent(MainActivity.this, SelectLog.class);
        startActivity(intent);
    }

    public void selectSpotButtonOnClick(View view) {
        Intent intent = new Intent(MainActivity.this, SelectSpot.class);
        startActivity(intent);
    }
}