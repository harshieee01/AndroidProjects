package com.vairagicodes.externalstorageexample;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
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

                if (isExternalStorageReadOnly() || !isExternalStorageAvailable()) {
                    Toast.makeText(MainActivity.this, "Storage is not available", Toast.LENGTH_SHORT).show();
                } else {

                    File file = new File(getExternalFilesDir("VairagiCodes"), fileNameEt.getText().toString());
                    writeData(file, fileDataEt.getText().toString());

                }

            }
        });


        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isExternalStorageReadOnly() || !isExternalStorageAvailable()) {
                    Toast.makeText(MainActivity.this, "Storage is not available", Toast.LENGTH_SHORT).show();
                } else {
                    File file = new File(getExternalFilesDir("VairagiCodes"), fileNameEt.getText().toString());

                    String data = readData(file);
                    dataTextView.setVisibility(View.VISIBLE);
                    dataTextView.setText(data);

                }
            }
        });

    }


    private static boolean isExternalStorageReadOnly() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    private static boolean isExternalStorageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    private void writeData(File file, String fileData) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(fileData.getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String readData(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

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