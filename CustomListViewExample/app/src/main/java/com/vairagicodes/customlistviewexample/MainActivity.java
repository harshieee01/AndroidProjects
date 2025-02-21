package com.vairagicodes.customlistviewexample;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.vairagicodes.customlistviewexample.adapter.FruitsAdapter;
import com.vairagicodes.customlistviewexample.model.FruitsModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView listView = findViewById(R.id.custom_list_view);
        ArrayList<FruitsModel> fruitsModels = new ArrayList<>();
        fruitsModels.add(new FruitsModel("Apple",R.drawable.apple));
        fruitsModels.add(new FruitsModel("Grapse",R.drawable.apple));
        fruitsModels.add(new FruitsModel("Apple",R.drawable.apple));
        fruitsModels.add(new FruitsModel("Apple",R.drawable.apple));
        fruitsModels.add(new FruitsModel("Apple",R.drawable.apple));
        fruitsModels.add(new FruitsModel("Apple",R.drawable.apple));
        fruitsModels.add(new FruitsModel("Apple",R.drawable.apple));
        fruitsModels.add(new FruitsModel("Apple",R.drawable.apple));
        fruitsModels.add(new FruitsModel("Apple",R.drawable.apple));
        fruitsModels.add(new FruitsModel("Apple",R.drawable.apple));
        fruitsModels.add(new FruitsModel("Apple",R.drawable.apple));
        fruitsModels.add(new FruitsModel("Apple",R.drawable.apple));
        fruitsModels.add(new FruitsModel("Apple",R.drawable.apple));

        FruitsAdapter fruitsAdapter = new FruitsAdapter(this,fruitsModels);
        listView.setAdapter(fruitsAdapter);

    }


}