package com.example.pyrov.calculator.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.pyrov.calculator.data.ExpressionContract.ExpressionEntry;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "history.db";

    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_HISTORY_TABLE = "CREATE TABLE "
                + ExpressionEntry.TABLE_NAME + " ("
                + ExpressionEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ExpressionEntry.COLUMN_DATE + " TEXT NOT NULL, "
                + ExpressionEntry.COLUMN_EXPRESSION + " TEXT NOT NULL);";
        db.execSQL(SQL_CREATE_HISTORY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
