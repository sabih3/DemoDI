package com.ahmed.sabih.demodi.di.component;


import com.ahmed.sabih.demodi.MainActivity;
import com.ahmed.sabih.demodi.di.PerActivity;
import com.ahmed.sabih.demodi.di.module.ActivityModule;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class,modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);


}


