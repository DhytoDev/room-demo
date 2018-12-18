package com.dhytodev.androidpersistenceroom;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import static androidx.room.OnConflictStrategy.IGNORE;

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
