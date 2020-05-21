package com.roomdbintegration.util;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.roomdbintegration.repository.local.AppDatabase;
import com.roomdbintegration.repository.local.UserDao;
import com.roomdbintegration.repository.local.model.User;

public class DBWorker extends Worker {
    AppDatabase instanceDB;

    public DBWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        instanceDB = Room.inMemoryDatabaseBuilder(getApplicationContext(), AppDatabase.class).build();
    }

    @NonNull
    @Override
    public Result doWork() {
        UserDao userDao = instanceDB.userDao();
        userDao.insertAllUser(new User(1, "Alpha", "Demon"));
        userDao.insertAllUser(new User(2, "Beta", "Demon"));
        userDao.insertAllUser(new User(3, "Gamma", "Demon"));
        userDao.insertAllUser(new User(4, "Donut", "Demon"));
        userDao.insertAllUser(new User(5, "Eclair", "Demon"));
        userDao.insertAllUser(new User(6, "Alpha", "Differed"));
        Log.d("List", "DBWorker: "+userDao.getUserList().get(0).firstName);
        Log.d("List", "DBWorker: "+userDao.findByName("Alpha", "Demon").id + "");
        return Result.success();
    }
}
