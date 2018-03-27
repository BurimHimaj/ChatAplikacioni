package com.chataplikacioni.chataplikacioni;


import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.app.Activity;
import android.database.Cursor;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by gimi on 3/26/2018.
 */

public class category  extends Activity {

    DatabaseHelper db;
    private Button refresh;
    private Button add;
    private ListView listContent;
    private EditText etKategori;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category);
        listContent = (ListView)findViewById(R.id.categoryList);
        etKategori = (EditText) findViewById(R.id.etKategori);

        db = new DatabaseHelper(this);

        RefreshData();

        refresh = (Button) findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RefreshData();
            }
        });

        add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newEntry = etKategori.getText().toString();
                if (etKategori.length() != 0){
                    AddData(newEntry);
                    etKategori.setText("");
                }
                else
                    Toast.makeText(category.this,"Shenojeni Kategorine",Toast.LENGTH_LONG).show();
            }
        });
    }

    public void AddData(String newEntry){
        boolean insertData = db.addData(newEntry);

        if (insertData == true)
            Toast.makeText(category.this,"Sapo keni shtuar Kategorine",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(category.this,"Nuk keni mundur te shtoni Kategorine",Toast.LENGTH_LONG).show();
        RefreshData();
    }

    public void RefreshData(){
        ArrayList<String> theList = new ArrayList<>();
        Cursor data = db.getListContents();

        if (data.getCount() == 0)
            Toast.makeText(this, "The DB is empty", Toast.LENGTH_LONG).show();
        else {
            while (data.moveToNext()){
                theList.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, theList);
                listContent.setAdapter(listAdapter);
            }
        }
    }
}
