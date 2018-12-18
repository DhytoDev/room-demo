package com.dhytodev.androidpersistenceroom.data;


import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity
public class User {
    @PrimaryKey
    @NonNull
    public String id;

    @NonNull
    public String nama;
}
