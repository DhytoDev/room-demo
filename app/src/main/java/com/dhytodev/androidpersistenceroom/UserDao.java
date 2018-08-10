package com.dhytodev.androidpersistenceroom;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;

@Dao
public interface UserDao {

    @Query("SELECT * FROM User")
    List<User> loadAllUsers();

    @Query("select * from user where id = :id")
    User loadUserById(String id);

    @Insert(onConflict = IGNORE)
    void insertUser(User user);

    @Query("DELETE FROM User")
    void deleteAll();
}
