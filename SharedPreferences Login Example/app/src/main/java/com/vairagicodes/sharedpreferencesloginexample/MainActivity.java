package com.vairagicodes.sharedpreferencesloginexample;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.vairagicodes.sharedpreferencesloginexample.util.SharedPrefUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean isUserLoggedIn = SharedPrefUtil.isUserLoggedIn(this);

        if (isUserLoggedIn) {
            startActivity(new Intent(MainActivity.this,
                    HomeScreenActivity.class));
            finish();
        } else {
            startActivity(new Intent(MainActivity.this,
                    LoginActivity.class));
            finish();
        }

    }
}