package com.example.greendaodemo;

import android.content.Context;

import com.aserbao.aserbaosandroid.functions.database.greenDao.db.DaoMaster;
import com.aserbao.aserbaosandroid.functions.database.greenDao.db.DaoSession;
import com.aserbao.aserbaosandroid.functions.database.greenDao.db.GoodsModelDao;

/**
 * author : lwz
 * date : 2022/10/26 16:34
 * desc :
 * version: 1.0
 */
public class GreenDaoManager {

    private static DaoSession mDaoSession;
    private static GreenDaoManager instance;

    private GreenDaoManager(){

    }

    public static GreenDaoManager getInstance(){
        if(instance == null){
            synchronized (GreenDaoManager.class){
                if(instance==null){
                    instance=new GreenDaoManager();
                }
            }
        }
        return instance;
    }

    public static void initGreenDao(){
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(MyApplication.getContext(),"greenDao.db",null);
        DaoMaster mDaoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoSession getDaoSession(){
        if(mDaoSession==null){
            throw new RuntimeException("请现在Application中初始化GreenDao");
        }
        return mDaoSession;
    }
}

