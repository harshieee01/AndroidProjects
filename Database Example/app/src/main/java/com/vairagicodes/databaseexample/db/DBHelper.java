package com.vairagicodes.databaseexample.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.vairagicodes.databaseexample.model.NotesModel;

import java.util.ArrayList;
import java.util.List;


public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "NotesDB";
    public static final int DB_VERSION = 1;

    public static final String TABLE_NAME = "NotesData";

    public static final String COL_ID = "id";
    public static final String COL_TITLE = "title";
    public static final String COL_DESCRIPTION = "description";


    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String dbQuery = "CREATE TABLE " + TABLE_NAME + "("
                + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COL_TITLE + " TEXT,"
                + COL_DESCRIPTION + " TEXT)";


        db.execSQL(dbQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addNotes(String title, String description) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_TITLE, title);
        values.put(COL_DESCRIPTION, description
        );

        db.insert("NotesData", null, values);

    }

    public List<NotesModel> fetchAllNotes() {

        List<NotesModel> notesModelList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String dbQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(dbQuery, null);


        if (cursor.getCount() != 0) {
            cursor.moveToFirst();

            do {
                NotesModel notesModel = new NotesModel(cursor.getString(1), cursor.getString(2));
                notesModel.setId(cursor.getInt(0));
                notesModelList.add(notesModel);
            }

            while (cursor.moveToNext());
        }

        cursor.close();


        return notesModelList;
    }

    public void updateRecord(NotesModel notesModel) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_TITLE, notesModel.getTitle());
        values.put(COL_DESCRIPTION, notesModel.getDescription());

        db.update(TABLE_NAME, values, COL_ID + "=?", new String[]{String.valueOf(notesModel.getId())});
        db.close();

    }

    public void deleteRecord(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COL_ID + "=?", new String[]{String.valueOf(id)});

    }

    //Code to get a single note
    public NotesModel getNote(int id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{COL_ID, COL_TITLE, COL_DESCRIPTION}, COL_ID + "=?", new String[]{String.valueOf(id)}, null, null, null);
        cursor.moveToFirst();

        NotesModel notesModel = new NotesModel(cursor.getString(1),
                cursor.getString(2));
        cursor.close();
        return notesModel;
    }


}
