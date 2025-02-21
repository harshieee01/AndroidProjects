package com.vairagicodes.databaseexample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.vairagicodes.databaseexample.db.DBHelper;
import com.vairagicodes.databaseexample.model.NotesModel;


public class NotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        int id = getIntent().getIntExtra("id", 1);

        DBHelper dbHelper = new DBHelper(NotesActivity.this);


        NotesModel notesModel = dbHelper.getNote(id);

        EditText notesTitle = findViewById(R.id.notes_title);
        EditText notesDes = findViewById(R.id.notes_des);
        Button updateBtn = findViewById(R.id.update_notes);
        Button deleteBtn = findViewById(R.id.delete_notes);

        notesTitle.setText(notesModel.getTitle());
        notesDes.setText(notesModel.getDescription());

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String noteDes = notesDes.getText().toString();
                String noteTitle = notesTitle.getText().toString();

                NotesModel notesModel = new NotesModel(noteTitle, noteDes);
                notesModel.setId(id);
                dbHelper.updateRecord(notesModel);

                Toast.makeText(NotesActivity.this, "Notes Updated", Toast.LENGTH_SHORT).show();

                finish();
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.deleteRecord(id);
                Toast.makeText(NotesActivity.this, "Notes Deleted", Toast.LENGTH_SHORT).show();
                finish();
            }
        });


    }
}