package com.chataplikacioni.chataplikacioni;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by gimi on 3/27/2018.
 */

public class Roli extends AppCompatActivity {

    DatabaseHelper db;
    private Button refresh;
    private Button add;
    private ListView listContent;
    private EditText etRoli;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roli);
        listContent = (ListView)findViewById(R.id.categoryList);
        etRoli = (EditText) findViewById(R.id.etRoli);

        db = new DatabaseHelper(this);


        refresh = (Button) findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }


}
