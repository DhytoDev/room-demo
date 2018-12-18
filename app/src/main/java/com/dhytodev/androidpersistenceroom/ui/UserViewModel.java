package com.dhytodev.androidpersistenceroom.ui;

import com.dhytodev.androidpersistenceroom.data.AppDatabase;
import com.dhytodev.androidpersistenceroom.data.User;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

public class UserViewModel extends ViewModel {
    private AppDatabase mDb;
    LiveData<PagedList<User>> userList;

    public UserViewModel(AppDatabase mDb) {
        this.mDb = mDb;
        userList = new LivePagedListBuilder<>(this.mDb.userModel().getAllUsers(), 5).build();
    }

    public static class Factory extends ViewModelProvider.NewInstanceFactory {
        private final AppDatabase mDb;

        public Factory(AppDatabase mDb) {
            this.mDb = mDb;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new UserViewModel(mDb);
        }
    }
}
