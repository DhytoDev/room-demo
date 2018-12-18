package com.dhytodev.androidpersistenceroom.ui;

import android.os.Bundle;

import com.dhytodev.androidpersistenceroom.R;
import com.dhytodev.androidpersistenceroom.data.AppDatabase;
import com.dhytodev.androidpersistenceroom.data.DatabaseInitializer;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private AppDatabase mDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        // Note: Db references should not be in an activity.
        mDb = AppDatabase.getInMemoryDatabase(getApplicationContext());

        populateDb();
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
}
