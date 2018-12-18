package com.dhytodev.androidpersistenceroom.ui;

import com.dhytodev.androidpersistenceroom.data.AppDatabase;
import com.dhytodev.androidpersistenceroom.data.User;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

public class UserViewModel extends ViewModel {
    private AppDatabase mDb ;
    private LiveData<PagedList<User>> userList ;

    public UserViewModel(AppDatabase mDb) {
        this.mDb = mDb;
        userList = new LivePagedListBuilder<>(this.mDb.userModel().getAllUsers(), 5).build();
    }
}
