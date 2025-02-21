package com.vairagicodes.sharedpreferencesloginexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.vairagicodes.sharedpreferencesloginexample.util.SharedPrefUtil;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginBtn = findViewById(R.id.login_btn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPrefUtil.saveIfUserIsLoggedIn(LoginActivity.this,true);
                startActivity(new Intent(LoginActivity.this,
                        HomeScreenActivity.class));
                finish();
            }
        });

    }
}