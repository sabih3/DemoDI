package com.ahmed.sabih.demodi.di;

import android.content.Context;
import android.content.res.Resources;

import com.ahmed.sabih.demodi.db.DBHelper;
import com.ahmed.sabih.demodi.model.User;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DataManager {

    private Context mContext;

    private DBHelper mDbHelper;

    private SharedPrefsHelper mSharedPrefsHelper;


    @Inject
    public DataManager(@ApplicationContext Context context,
                       DBHelper mDbHelper,
                       SharedPrefsHelper mSharedPrefsHelper) {
        this.mContext = mContext;
        this.mDbHelper = mDbHelper;
        this.mSharedPrefsHelper = mSharedPrefsHelper;
    }

    public void saveAccessToken(String accessToken) {
        mSharedPrefsHelper.put(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, accessToken);
    }

    public String getAccessToken(){
        return mSharedPrefsHelper.get(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, null);
    }

    public Long createUser(User user) throws Exception {
        return mDbHelper.insertUser(user);
    }

    public User getUser(Long userId) throws Resources.NotFoundException, NullPointerException {
        return mDbHelper.getUser(userId);
    }
}
