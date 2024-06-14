package com.example.test_database;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ImagesDB.db";
    private static final int DATABASE_VERSION = 1;

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE images (id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT NOT NULL, image_path TEXT NOT NULL)");
        insertSampleData(db);
    }
    public Cursor getAllImages() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM images", null);
    }
    private void insertSampleData(SQLiteDatabase db) {
        db.execSQL("INSERT INTO images (title, image_path) VALUES ('Image 1', 'badminton.png')");
        db.execSQL("INSERT INTO images (title, image_path) VALUES ('Image 2', 'football.png')");
        db.execSQL("INSERT INTO images (title, image_path) VALUES ('Image 3', 'GiamMo.png')");
        db.execSQL("INSERT INTO images (title, image_path) VALUES ('Image 4', 'running.png')");
        db.execSQL("INSERT INTO images (title, image_path) VALUES ('Image 5', 'TangCo.png')");
        db.execSQL("INSERT INTO images (title, image_path) VALUES ('Image 6', 'volleyball.png')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS images");
        onCreate(db);
    }
}
