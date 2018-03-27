package com.chataplikacioni.chataplikacioni.activities;

/**
 * Created by User on 3/27/2018.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;

import com.chataplikacioni.chataplikacioni.R;
import com.chataplikacioni.chataplikacioni.model.User;
import com.chataplikacioni.chataplikacioni.sql.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;


public class UsersActivity extends AppCompatActivity {

    private AppCompatActivity activity = UsersActivity.this;
    private AppCompatTextView textViewName;
    private List<User> welcome;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        getSupportActionBar().setTitle("");
        initViews();
        initObjects();

    }

    /**
     * incialiimi views
     */
    private void initViews() {
        textViewName = (AppCompatTextView) findViewById(R.id.textViewName);

    }

    private void initObjects() {
        welcome = new ArrayList<>();
        databaseHelper = new DatabaseHelper(activity);

    }
}
