package com.example.greendaodemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.aserbao.aserbaosandroid.functions.database.greenDao.db.UserDao;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tvInsert = findViewById(R.id.tv_insert);
        tvInsert.setOnClickListener(view -> saveBean());
        TextView tvQuery = findViewById(R.id.tv_query);
        tvQuery.setOnClickListener(view -> queryBean());
        TextView tvDelete = findViewById(R.id.tv_delete);
        tvDelete.setOnClickListener(view -> deleteBean());
        TextView tvUpdate = findViewById(R.id.tv_update);
        tvUpdate.setOnClickListener(view -> updateBean());
    }

    public void saveBean(){
        User user = new User();
        user.setName("aaa");
        user.setAge(11);
        user.setSex("男");
        user.setAddress("上海");
        long flag = GreenDaoManager.getInstance().getDaoSession().getUserDao().insert(user);
        Log.e(TAG, "flag="+flag);
    }

    public void queryBean(){
        // 查单条
        User user1 = GreenDaoManager.getInstance().getDaoSession().getUserDao().queryBuilder()
                .where(UserDao.Properties.Id.eq(1)).build().unique();
        Log.e(TAG,"user1="+user1);
        // 查所有
        List<User> users = GreenDaoManager.getInstance().getDaoSession().getUserDao().loadAll();
        Log.e(TAG,"users="+users);
    }

    public void deleteBean(){
        // 查询需要删除的目标
        User user = GreenDaoManager.getInstance().getDaoSession().getUserDao().queryBuilder()
            .where(UserDao.Properties.Id.eq(1)).build().unique();
        if(user != null){
            // 删除单行
            GreenDaoManager.getInstance().getDaoSession().getUserDao().deleteByKey(user.getId());
            Log.e(TAG, "删除成功");
        }else{
            Log.e(TAG, "删除目标不存在");
        }
        // 2.删除所有
//        GreenDaoManager.getInstance().getDaoSession().getUserDao().deleteAll();
    }

    public void updateBean(){
        // 查询需要修改的目标
        User user = GreenDaoManager.getInstance().getDaoSession().getUserDao().queryBuilder()
                .where(UserDao.Properties.Id.eq(2)).build().unique();
        if(user != null){
            user.setName("刘德");
            GreenDaoManager.getInstance().getDaoSession().getUserDao().updateInTx(user);
            Log.e(TAG, "修改成功");
        }else{
            Log.e(TAG, "修改对象不存在");
        }
    }
}