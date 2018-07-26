package com.example.pyrov.calculator.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pyrov.calculator.App;
import com.example.pyrov.calculator.data.ExpressionContract.ExpressionEntry;
import com.example.pyrov.calculator.model.Expression;

import java.util.ArrayList;
import java.util.List;

public final class DataStorage {
    private static DBHelper dbHelper;

    private static List<Expression> expressionsList;

    public DataStorage() {
        dbHelper = new DBHelper(App.getAppContext());
        expressionsList = new ArrayList<>();
    }

    public List<Expression> getExpressionsList() {
        expressionsList.clear();
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        String[] projection = {
                ExpressionEntry._ID,
                ExpressionEntry.COLUMN_DATE,
                ExpressionEntry.COLUMN_EXPRESSION
        };

        Cursor cursor = database.query(
                ExpressionEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );

        try {
            int columnDate = cursor.getColumnIndex(ExpressionEntry.COLUMN_DATE);
            int columnExpression = cursor.getColumnIndex(ExpressionEntry.COLUMN_EXPRESSION);

            while (cursor.moveToNext()) {
                String date = cursor.getString(columnDate);
                String expression = cursor.getString(columnExpression);
                expressionsList.add(new Expression(date, expression));
            }

        } finally {
            cursor.close();
        }
        return expressionsList;
    }

    public void insertExpression(Expression expression) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ExpressionEntry.COLUMN_DATE, expression.getDate());
        contentValues.put(ExpressionEntry.COLUMN_EXPRESSION, expression.getExpression());
        database.insert(ExpressionEntry.TABLE_NAME, null, contentValues);
    }

    public void clearTable() {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        database.delete(ExpressionEntry.TABLE_NAME, null, null);
    }
}
