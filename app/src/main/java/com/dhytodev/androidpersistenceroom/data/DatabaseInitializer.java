package com.dhytodev.androidpersistenceroom.data;
import com.dhytodev.androidpersistenceroom.data.AppDatabase;
import com.dhytodev.androidpersistenceroom.data.User;

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
        addUser(db, "3", "Dhyto");
        addUser(db, "4", "Angga");
        addUser(db, "5", "Pratama");
        addUser(db, "6", "Ricky");
        addUser(db, "7", "Kawanda");
        addUser(db, "8", "Suwardi");
        addUser(db, "9", "Kevin");
        addUser(db, "10", "Sanjaya");
        addUser(db, "11", "Sukamulyo");
        addUser(db, "12", "Tontowi");
        addUser(db, "13", "Ahmad");
        addUser(db, "14", "Hendra");
        addUser(db, "15", "Setiawan");
        addUser(db, "16", "Reza");
        addUser(db, "17", "Alamsyah");
        addUser(db, "18", "Maulana");
        addUser(db, "19", "Kasmir");
        addUser(db, "20", "Syariati");
        addUser(db, "21", "Mawar");
    }
}
