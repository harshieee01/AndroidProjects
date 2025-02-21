package com.vairagicodes.customlistviewexample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.vairagicodes.customlistviewexample.R;
import com.vairagicodes.customlistviewexample.model.FruitsModel;

import java.util.ArrayList;

public class FruitsAdapter extends ArrayAdapter<FruitsModel> {
    public FruitsAdapter(@NonNull Context context, ArrayList<FruitsModel> fruits) {
        super(context,0,fruits);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        View view = convertView;

        if(view==null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.fruits_view,parent,false);

        }

        FruitsModel currentFruit = getItem(position);

        TextView textView = view.findViewById(R.id.fruit_tv);
        ImageView imageView = view.findViewById(R.id.fruit_iv);

        if(currentFruit!=null) {
            textView.setText(currentFruit.getFruitTitle());
            imageView.setImageResource(currentFruit.getFruitImage());
        }

        return view;
    }
}
