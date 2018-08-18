package com.ahmed.sabih.demodi.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.ahmed.sabih.demodi.di.ApplicationContext;
import com.ahmed.sabih.demodi.di.DatabaseInfo;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application app) {
        mApplication = app;
    }

    @Provides
    @ApplicationContext
    Context provideContext(){
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String getProvideDatabaseName(){
        return "demo-dagger.db";
    }

    @Provides
    @DatabaseInfo
    Integer provideDatabaseVersion(){
        return 2;
    }

    @Provides
    SharedPreferences provideSharedPrefs(){
        return mApplication.getSharedPreferences("demo-prefs",Context.MODE_PRIVATE);
    }

}
