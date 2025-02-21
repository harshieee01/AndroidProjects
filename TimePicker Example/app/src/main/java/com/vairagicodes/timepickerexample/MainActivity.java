package com.vairagicodes.timepickerexample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button getTimeButton = findViewById(R.id.get_time_button);
        TextView setTimeTextView = findViewById(R.id.time_tv);
        TimePicker timePicker = findViewById(R.id.current_time_picker);

        timePicker.setIs24HourView(false);

        getTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour = timePicker.getHour();
                int minute = timePicker.getMinute();
                setTimeTextView.setText(hour + ":" + minute);
                setTimeTextView.setVisibility(View.VISIBLE);
            }
        });

    }
}