package com.ahmed.sabih.demodi;

import android.app.Application;
import android.content.Context;

import com.ahmed.sabih.demodi.di.ApplicationContext;
import com.ahmed.sabih.demodi.di.DataManager;
import com.ahmed.sabih.demodi.di.component.ApplicationComponent;
import com.ahmed.sabih.demodi.di.module.ApplicationModule;

import javax.inject.Inject;

import dagger.android.DaggerApplication;
import dagger.android.support.DaggerAppCompatActivity;
import dagger.internal.DaggerCollections;

public class DemoApplication extends Application {


    protected ApplicationComponent applicationComponent;

    @Inject
    DataManager dataManager;

    public static DemoApplication get(Context context) {
        return (DemoApplication)context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();


        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);
    }

    public ApplicationComponent getComponent(){
        return applicationComponent;
    }
}
