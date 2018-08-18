package com.ahmed.sabih.demodi;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ahmed.sabih.demodi.di.DataManager;
import com.ahmed.sabih.demodi.di.component.ActivityComponent;
import com.ahmed.sabih.demodi.di.module.ActivityModule;
import com.ahmed.sabih.demodi.model.User;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    DataManager mDataManager;

    public ActivityComponent activityComponent;

    public ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(DemoApplication.get(this).getComponent())
                    .build();
        }
        return activityComponent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);


    }

    private void createUser(){
        try {
            mDataManager.createUser(new User("Ali", "1367, Gurgaon, Haryana, India"));
        }catch (Exception e){e.printStackTrace();}
    }

    private void getUser(){
        try {
            User user = mDataManager.getUser(1L);
            //mTvUserInfo.setText(user.toString());
        }catch (Exception e){e.printStackTrace();}
    }
}
