package com.vairagicodes.databaseexample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.vairagicodes.databaseexample.R;
import com.vairagicodes.databaseexample.model.NotesModel;

import java.util.ArrayList;

public class NotesAdapter extends ArrayAdapter<NotesModel> {
    public NotesAdapter(Context context, ArrayList<NotesModel> notesModels) {
        super(context, 0, notesModels);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;


        if (v == null) {
            v = LayoutInflater.from(getContext()).inflate(R.layout.notes_view, parent, false);
        }


        NotesModel notesModel = getItem(position);
        TextView notesTitle = v.findViewById(R.id.notes_view_title);
        TextView notesDescription = v.findViewById(R.id.notes_view_des);

        if (notesModel != null) {

            notesTitle.setText(notesModel.getTitle());
            notesDescription.setText(notesModel.getDescription());

        }


        return v;
    }
}
