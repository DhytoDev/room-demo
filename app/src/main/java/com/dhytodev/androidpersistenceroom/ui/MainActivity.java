package com.dhytodev.androidpersistenceroom.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.dhytodev.androidpersistenceroom.R;
import com.dhytodev.androidpersistenceroom.data.AppDatabase;
import com.dhytodev.androidpersistenceroom.data.DatabaseInitializer;
import com.dhytodev.androidpersistenceroom.data.User;

import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private AppDatabase mDb;

    private TextView mYoungUsersTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mYoungUsersTextView = findViewById(R.id.young_users_tv);

        // Note: Db references should not be in an activity.
        mDb = AppDatabase.getInMemoryDatabase(getApplicationContext());

        populateDb();

//        fetchData();
    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }

    private void populateDb() {
        DatabaseInitializer.populateSync(mDb);
        DatabaseInitializer.addUser(mDb, "3", "Bambang");
    }

    /*private void fetchData() {
        // Note: this kind of logic should not be in an activity.
        StringBuilder sb = new StringBuilder();
        List<User> users = mDb.userModel().loadAllUsers();

        for (User user : users) {
            sb.append(String.format(Locale.US,
                    "%s, %s \n", user.id, user.nama));
        }
        Log.d("users", sb.toString());

        *//*for (int i = 0; i < users.size(); i++) {
            sb.append(String.format(Locale.US,
                    "%s, %s \n", users.get(i).id, users.get(i).nama));
        }*//*

        mYoungUsersTextView.setText(sb);

       *//* User user = mDb.userModel().loadUserById("1");

        mYoungUsersTextView.setText(user.nama);*//*
    }*/
}
