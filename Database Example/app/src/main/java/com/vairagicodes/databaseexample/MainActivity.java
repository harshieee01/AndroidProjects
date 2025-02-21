package com.vairagicodes.databaseexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.vairagicodes.databaseexample.db.DBHelper;
import com.vairagicodes.databaseexample.model.NotesModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        DBHelper dbHelper = new DBHelper(MainActivity.this);


        EditText notesTitle = findViewById(R.id.notes_title);
        EditText notesDes = findViewById(R.id.notes_des);
        Button saveBtn = findViewById(R.id.save_notes);

        Button readBtn = findViewById(R.id.read_notes);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String noteDes = notesDes.getText().toString();
                String noteTitle = notesTitle.getText().toString();

                NotesModel notesModel = new NotesModel(noteTitle, noteDes);
                dbHelper.addNotes(notesModel.getTitle(), notesModel.getDescription());

                notesTitle.setText("");
                notesDes.setText("");

                Toast.makeText(MainActivity.this,"Note Saved",Toast.LENGTH_SHORT).show();
            }
        });

        readBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,AllNotesActivity.class));
            }
        });


    }
}