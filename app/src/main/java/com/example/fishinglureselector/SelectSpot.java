package com.example.fishinglureselector;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SelectSpot extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_spot);
        buildButtons(SelectSpot.this);
    }


    public void newSpotButtonOnClick(View view) {


        Intent intent = new Intent(SelectSpot.this, NewSpot.class);
        startActivity(intent);

    }

    private void buildButtons(Context context){
        FishSpot jsonSpot;
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.spot_lin_layout);
        ArrayList<String> spotName = retrieveJSON("buttonNames.json");
        if (spotName != null) {
            int len = spotName.size();
            for (int i = 0; i < len; i ++) {
                Button btnTag = new Button(this);
                btnTag.setLayoutParams(new LinearLayout.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT,
                        ActionBar.LayoutParams.WRAP_CONTENT));
                btnTag.setText(spotName.get(i));
                linearLayout.addView(btnTag);
            }
        }
    }

    private ArrayList<String> retrieveJSON(String fileName) {
        File file = new File(getFilesDir().toString() + "/" + fileName);
        FileReader fileReader;
        ArrayList spotList = new ArrayList();
        try {
            fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            JSONObject spot = (JSONObject) new JSONTokener(line).nextValue();
            spotList.add(spot.getString("name"));
            line = bufferedReader.readLine();
            int count = 1;
            while (line != null) {
                spotList.add(((JSONObject) new JSONTokener(line).nextValue()).getString("name"));
                line = bufferedReader.readLine();
                count++;
            }
        bufferedReader.close();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            return null;
        }
        return spotList;
    }
}