package com.example.guill.marvel.modules;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    Application application;

    public AppModule(Application app){
        this.application = app;
    }

    @Provides
    @Singleton
    Application provideApplication(){
        return this.application;
    }
}
