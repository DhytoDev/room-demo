package com.dhytodev.androidpersistenceroom.ui;

import android.os.Bundle;

import com.dhytodev.androidpersistenceroom.R;
import com.dhytodev.androidpersistenceroom.data.AppDatabase;
import com.dhytodev.androidpersistenceroom.data.DatabaseInitializer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private AppDatabase mDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView  = findViewById(R.id.user_recycler_view);

        // Note: Db references should not be in an activity.
        mDb = AppDatabase.getInMemoryDatabase(getApplicationContext());

        populateDb();

        UserViewModel.Factory factory = new UserViewModel.Factory(mDb);
        UserViewModel userViewModel = ViewModelProviders.of(this, factory).get(UserViewModel.class);

        UserAdapter adapter = new UserAdapter();
        userViewModel.userList.observe(this, adapter::submitList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }

    private void populateDb() {
        DatabaseInitializer.populateSync(mDb);
//        DatabaseInitializer.addUser(mDb, "3", "Bambang");
    }
}
