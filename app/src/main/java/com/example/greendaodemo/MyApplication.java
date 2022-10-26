package com.example.greendaodemo;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.aserbao.aserbaosandroid.functions.database.greenDao.db.DaoMaster;
import com.aserbao.aserbaosandroid.functions.database.greenDao.db.DaoSession;

/**
 * author : lwz
 * date : 2022/10/26 16:33
 * desc :
 * version: 1.0
 */
public class MyApplication extends Application {

    private static Context mContext;


    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;

        GreenDaoManager.initGreenDao();

    }

    public static Context getContext(){
        return mContext;
    }


}


