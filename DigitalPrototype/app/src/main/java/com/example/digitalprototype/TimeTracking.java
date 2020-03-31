package com.example.digitalprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TimeTracking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_tracking);
    }

    public void launchAppUsage(View view) {
        Intent intent = new Intent(this, AppTimeTracking.class);
        startActivity(intent);
    }

    public void launchActivityTrack(View view) {
        Intent intent = new Intent(this, ActTimeTracking.class);
        startActivity(intent);
    }
}
