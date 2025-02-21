package com.vairagicodes.sharedprefexample;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.vairagicodes.sharedprefexample.util.SharedPrefUtil;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        SharedPreferences sharedPreferences = getSharedPreferences("userPref",MODE_PRIVATE);

        int value = sharedPreferences.getInt("UserLogin",1);

        Toast.makeText(this,value+" ",Toast.LENGTH_SHORT).show();


        SharedPrefUtil.userLogeedInOrNot(this,true);
        Boolean isUserLogin = SharedPrefUtil.isUserLoggedIn(this);


    }
}