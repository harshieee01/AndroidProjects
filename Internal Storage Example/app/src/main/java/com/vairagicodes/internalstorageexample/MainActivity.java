package com.vairagicodes.internalstorageexample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button saveButton = findViewById(R.id.btn_save_file);
        Button readButton = findViewById(R.id.btn_read_file);

        EditText fileNameEt = findViewById(R.id.file_name_et);
        EditText fileDataEt = findViewById(R.id.file_data_et);
        TextView dataTextView = findViewById(R.id.data_tv);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = fileNameEt.getText().toString();
                String data = fileDataEt.getText().toString();
                writeData(name,data);
            }
        });

        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = fileNameEt.getText().toString();
                String data = readData(name);
                dataTextView.setVisibility(View.VISIBLE);
                dataTextView.setText(data);
            }
        });
    }

    private void writeData(String fileName, String fileData) {
        try {
            FileOutputStream fileOutputStream = openFileOutput(fileName,
                    MODE_PRIVATE);

            fileOutputStream.write(fileData.getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String readData(String fileName) {

        try {

            FileInputStream fileInputStream = openFileInput(fileName);

            InputStreamReader inputStreamReader =
                    new InputStreamReader(fileInputStream);

            BufferedReader bufferedReader =
                    new BufferedReader(inputStreamReader);

            StringBuilder stringBuilder = new StringBuilder();
            String text = null;

            while ((text = bufferedReader.readLine()) != null) {
                stringBuilder.append(text);
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}