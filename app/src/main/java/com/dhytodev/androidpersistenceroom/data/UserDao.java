package com.dhytodev.androidpersistenceroom.data;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import static androidx.room.OnConflictStrategy.IGNORE;

@Dao
public interface UserDao {

    @Query("SELECT * FROM User")
    DataSource.Factory<Integer, User> getAllUsers();

    @Query("select * from user where id = :id")
    User loadUserById(String id);

    @Insert(onConflict = IGNORE)
    void insertUser(User user);

    @Query("DELETE FROM User")
    void deleteAll();
}
