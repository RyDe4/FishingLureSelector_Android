package com.example.fishinglureselector;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.concurrent.Executor;

public class NewSpot extends AppCompatActivity {

    private FishSpot spot = new FishSpot();

    private SelectSpotViewModel model = new SelectSpotViewModel(this.getApplication());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_spot);

        Spinner spotTypeSpinner = (Spinner) findViewById(R.id.spot_spinner);
        ArrayAdapter<CharSequence> spot_type_adapter = ArrayAdapter.createFromResource(this,
                R.array.spot_type_array, android.R.layout.simple_spinner_item);
        spot_type_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spotTypeSpinner.setAdapter(spot_type_adapter);

        spotTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Object spotType = parent.getItemAtPosition(pos);
                spot.setGenerateTypeCode(spotType.toString());
            }
            public void onNothingSelected(AdapterView<?> parent) {
                spot.setGenerateTypeCode("Lake/Pond");
            }
        });

        Spinner spotSizeSpinner = (Spinner) findViewById(R.id.spot_size_spinner);
        ArrayAdapter<CharSequence> spotSizeAdapter = ArrayAdapter.createFromResource(this,
                R.array.water_size_array, android.R.layout.simple_spinner_item);
        spot_type_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spotSizeSpinner.setAdapter(spotSizeAdapter);

        spotSizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Object spotSize = parent.getItemAtPosition(pos);
                spot.setGenerateSize(spotSize.toString());
            }
            public void onNothingSelected(AdapterView<?> parent) {
                spot.setGenerateSize("medium");
            }
        });

        Spinner bottomSpinner = (Spinner) findViewById(R.id.bottom_spinner);
        ArrayAdapter<CharSequence> bottomCompAdapter = ArrayAdapter.createFromResource(this,
                R.array.bottom_comp_array, android.R.layout.simple_spinner_item);
        bottomCompAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bottomSpinner.setAdapter(bottomCompAdapter);

        bottomSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Object bottomType = parent.getItemAtPosition(pos);
                spot.setGenerateBottom(bottomType.toString());
            }
            public void onNothingSelected(AdapterView<?> parent) {
                spot.setGenerateBottom("rock");
            }
        });
    }

    public void makeSpotButtonOnClick(View view) {
        EditText spotNameText = (EditText)findViewById(R.id.spotNameText);
        String newButtonText = spotNameText.getText().toString();
        this.spot.setName(newButtonText);
        Intent intent = new Intent(NewSpot.this, SelectSpot.class);

        SpotDataEntry newSpot = new SpotDataEntry();
        newSpot.spotName = spot.getName();
        newSpot.bottom = spot.getBottom();
        newSpot.size = spot.getSize();
        newSpot.typeCode = spot.getTypeCode();

        model.insert(newSpot);

        startActivity(intent);
    }

    private void writeToFile(String data, Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new
                    OutputStreamWriter(context.openFileOutput
                    ("buttonNames.json", MODE_APPEND));
            outputStreamWriter.write(data + "\n");
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

}