package com.dhytodev.androidpersistenceroom;
import androidx.annotation.NonNull;

public class DatabaseInitializer {


    public static void populateSync(@NonNull final AppDatabase db) {
        populateDataDummy(db);
    }

    public static User addUser(final AppDatabase db, final String id, final String nama) {
        User user = new User();
        user.id = id;
        user.nama = nama;
        db.userModel().insertUser(user);
        return user;
    }

    private static void populateDataDummy(AppDatabase db) {
        db.userModel().deleteAll();

        addUser(db, "1", "Baso");
        addUser(db, "2", "Bacce");
    }
}
