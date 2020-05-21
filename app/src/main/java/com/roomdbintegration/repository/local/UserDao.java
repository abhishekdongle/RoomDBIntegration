package com.roomdbintegration.repository.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.roomdbintegration.repository.local.model.User;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getUserList();

    @Insert
    void insertAllUser(User... users);

    @Query("SELECT * FROM user WHERE firstName LIKE :first AND "
            + "lastName LIKE :last LIMIT 1")
    User findByName(String first, String last);

}
