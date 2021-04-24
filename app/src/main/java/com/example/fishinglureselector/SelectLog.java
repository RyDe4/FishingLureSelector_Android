package com.example.fishinglureselector;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class SelectLog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_log);
    }

    public void newReportsButtonOnClick(View view) {
        Button btnTag = new Button(this);
        btnTag.setLayoutParams(new LinearLayout.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT,
                ActionBar.LayoutParams.WRAP_CONTENT));
        Intent intent = new Intent(SelectLog.this, NewSpot.class);
        startActivity(intent);

        btnTag.setText("Button");
        btnTag.generateViewId();

        LinearLayout linearLayout=(LinearLayout)findViewById(R.id.report_lin_layout);

        linearLayout.addView(btnTag);
    }
}