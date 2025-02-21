package com.vairagicodes.androidactivitylifecycle;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Log.d("Activity LifeCycle","This is onCreate");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Activity LifeCycle","This is onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Activity LifeCycle","This is onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Activity LifeCycle","This is onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Activity LifeCycle","This is onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Activity LifeCycle","This is onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Activity LifeCycle","This is onDestroy");
    }
}