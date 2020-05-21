package com.roomdbintegration.repository.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.roomdbintegration.repository.local.model.User;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
