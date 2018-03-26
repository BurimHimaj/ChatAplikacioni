package com.chataplikacioni.chataplikacioni;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.content.Intent;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private Button kycu;
    private Button autoret;


    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHelper(this);


        kycu =  findViewById(R.id.kycu);

        kycu.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent myIntent = new Intent(view.getContext(), category.class);
                        startActivity(myIntent);
                        // startActivityForResult(myIntent, 0);
                    }
                }
        );

        autoret =  findViewById(R.id.autoret);

        autoret.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent myIntent = new Intent(view.getContext(), About.class);
                        startActivity(myIntent);
                        // startActivityForResult(myIntent, 0);
                    }
                }
        );
    }
}
