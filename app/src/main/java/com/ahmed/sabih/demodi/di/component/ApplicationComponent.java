package com.ahmed.sabih.demodi.di.component;


import android.app.Application;
import android.content.Context;

import com.ahmed.sabih.demodi.DemoApplication;
import com.ahmed.sabih.demodi.db.DBHelper;
import com.ahmed.sabih.demodi.di.ApplicationContext;
import com.ahmed.sabih.demodi.di.DataManager;
import com.ahmed.sabih.demodi.di.SharedPrefsHelper;
import com.ahmed.sabih.demodi.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(DemoApplication demoApplication);

    @ApplicationContext
    Context getContext();

    Application getApplication();

    DataManager getDataManager();

    SharedPrefsHelper getPreferenceHelper();

    DBHelper getDbHelper();
}
