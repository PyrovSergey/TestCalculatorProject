package com.example.pyrov.calculator.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Expression implements Parcelable {
    private String date;

    private String expression;

    public String getDate() {
        return date;
    }

    public String getExpression() {
        return expression;
    }

    public Expression(String date, String expression) {
        this.date = date;
        this.expression = expression;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.date);
        dest.writeString(this.expression);
    }

    protected Expression(Parcel in) {
        this.date = in.readString();
        this.expression = in.readString();
    }

    public static final Parcelable.Creator<Expression> CREATOR = new Parcelable.Creator<Expression>() {
        @Override
        public Expression createFromParcel(Parcel source) {
            return new Expression(source);
        }

        @Override
        public Expression[] newArray(int size) {
            return new Expression[size];
        }
    };
}
