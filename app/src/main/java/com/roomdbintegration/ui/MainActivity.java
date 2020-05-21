package com.roomdbintegration.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.roomdbintegration.R;
import com.roomdbintegration.repository.local.AppDatabase;
import com.roomdbintegration.repository.local.UserDao;
import com.roomdbintegration.repository.local.model.User;
import com.roomdbintegration.util.DBWorker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create instance of room db

        WorkRequest request = new OneTimeWorkRequest.Builder(DBWorker.class).build();
        WorkManager.getInstance(this).enqueue(request);

//        new DBWorker(instanceDB, this);

      /*  new AsyncTask<Context, UserDao, UserDao>() {

            @Override
            protected UserDao doInBackground(Context... contexts) {

                UserDao userDao;
                userDao = instanceDB.userDao();
                userDao.insertAllUser(new User(1, "Alpha", "Demon"));
                userDao.insertAllUser(new User(2, "Beta", "Demon"));
                userDao.insertAllUser(new User(3, "Gamma", "Demon"));
                userDao.insertAllUser(new User(4, "Donut", "Demon"));
                userDao.insertAllUser(new User(5, "Eclair", "Demon"));
                userDao.insertAllUser(new User(6, "Alpha", "Differed"));
                Log.d("List", userDao.getUserList().get(0).firstName);
                Log.d("List", userDao.findByName("Alpha", "Demon").id+"");
                return userDao;
            }

            @Override
            protected void onPostExecute(UserDao userDao) {
                super.onPostExecute(userDao);

            }
        }.execute(this);*/
    }
}
