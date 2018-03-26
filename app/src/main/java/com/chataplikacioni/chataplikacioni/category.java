package com.chataplikacioni.chataplikacioni;


import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.app.Activity;
import android.database.Cursor;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gimi on 3/26/2018.
 */

public class category  extends Activity {

    DatabaseHelper db;
    private Button refresh;
    private Button delete;
    private ListView listContent;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category);
        listContent = (ListView)findViewById(R.id.categoryList);

        db = new DatabaseHelper(this);

        RefreshData();

        refresh = (Button) findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RefreshData();
            }
        });

        delete = findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.delete();
            }
        });

    }

    public void RefreshData(){
        ArrayList<String> theList = new ArrayList<>();
        Cursor data = db.getListContents();

        if (data.getCount() == 0){
            Toast.makeText(this, "The DB is empty", Toast.LENGTH_LONG).show();
        }
        else {
            while (data.moveToNext()){
                theList.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, theList);
                listContent.setAdapter(listAdapter);
            }
        }
    }
}
