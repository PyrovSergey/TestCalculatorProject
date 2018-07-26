package com.example.pyrov.calculator.data;

import android.provider.BaseColumns;

public final class ExpressionContract {
    private ExpressionContract() {
    }

    public static final class ExpressionEntry implements BaseColumns {

        public static final String TABLE_NAME = "history_expressions";

        public static final String _ID = BaseColumns._ID;

        public static final String COLUMN_DATE = "date";

        public static final String COLUMN_EXPRESSION = "expression";
    }
}
