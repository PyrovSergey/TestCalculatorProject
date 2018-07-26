package com.example.pyrov.calculator;

import android.app.Application;
import android.content.Context;

public class App extends Application {
    private static Context context;
    private static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        component = DaggerAppComponent.create();
    }

    public static Context getAppContext() {
        return context;
    }

    public static AppComponent getComponent() {
        return component;
    }
}
