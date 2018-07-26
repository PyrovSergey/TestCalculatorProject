package com.example.pyrov.calculator;

import com.example.pyrov.calculator.data.DataStorage;
import com.example.pyrov.calculator.data.DataStorageModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = DataStorageModule.class)
public interface AppComponent {
    DataStorage getDataStorage();
}
