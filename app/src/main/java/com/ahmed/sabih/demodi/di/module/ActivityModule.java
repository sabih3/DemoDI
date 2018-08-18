package com.ahmed.sabih.demodi.di.module;

import android.app.Activity;
import android.content.Context;

import com.ahmed.sabih.demodi.di.ActivityContext;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity mActivity) {
        this.mActivity = mActivity;
    }

    @Provides
    @ActivityContext
    Context provideContext(){
        return mActivity;
    }

    @Provides
    Activity provideActivity(){
        return mActivity;
    }
}
