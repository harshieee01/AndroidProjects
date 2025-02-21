package com.vairagicodes.fragmentexample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.vairagicodes.fragmentexample.fragment.LoginFragment;
import com.vairagicodes.fragmentexample.fragment.RegisterFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button loginBtn = findViewById(R.id.login_btn);
        Button registerBtn = findViewById(R.id.registration_btn);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LoginFragment loginFragment = new LoginFragment();

                getSupportFragmentManager().beginTransaction().replace(R.id.selection_fragment, loginFragment).commit();
            }
        });


        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.selection_fragment, new RegisterFragment()).commit();
            }
        });


    }
}