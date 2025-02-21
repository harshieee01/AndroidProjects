package com.vairagicodes.listviewexample;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String [] fruits = {"Apple","Mango","Banana","Orange","Grapes","Watermelon"};
        ListView listView = findViewById(R.id.fruit_list_view);
        ArrayAdapter<String> fruitsAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,fruits);
        listView.setAdapter(fruitsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,fruits[position],Toast.LENGTH_SHORT).show();
            }
        });

    }
}