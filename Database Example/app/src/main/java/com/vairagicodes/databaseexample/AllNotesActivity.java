package com.vairagicodes.databaseexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.vairagicodes.databaseexample.adapter.NotesAdapter;
import com.vairagicodes.databaseexample.db.DBHelper;
import com.vairagicodes.databaseexample.model.NotesModel;

import java.util.ArrayList;


public class AllNotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_notes);


    }

    @Override
    protected void onResume() {
        super.onResume();

        ListView notesListView = findViewById(R.id.notes_list_view);

        DBHelper dbHelper = new DBHelper(AllNotesActivity.this);

        ArrayList<NotesModel> notesModels;

        notesModels = (ArrayList<NotesModel>) dbHelper.fetchAllNotes();
        NotesAdapter notesAdapter = new NotesAdapter(this, notesModels);


        notesListView.setAdapter(notesAdapter);

        notesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(AllNotesActivity.this, NotesActivity.class);
                NotesModel notesModel = notesAdapter.getItem(i);
                assert notesModel != null;
                intent.putExtra("id", notesModel.getId());
                startActivity(intent);
            }
        });

        notesAdapter.notifyDataSetChanged();
        dbHelper.close();
        if (notesModels.isEmpty()) {
            Toast.makeText(AllNotesActivity.this, "No Notes Found", Toast.LENGTH_SHORT).show();
        }

    }

}