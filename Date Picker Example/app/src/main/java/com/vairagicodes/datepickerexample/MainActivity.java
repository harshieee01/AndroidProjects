package com.vairagicodes.datepickerexample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatePicker datePicker = findViewById(R.id.current_date_picker);
        Button button = findViewById(R.id.get_date_button);
        TextView setDateTextView = findViewById(R.id.date_tv);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth();
                int year = datePicker.getYear();

                setDateTextView.setVisibility(View.VISIBLE);
                setDateTextView.setText("Selected Date: " + day + "/" + (month + 1) + "/" + year);

            }
        });

    }
}
