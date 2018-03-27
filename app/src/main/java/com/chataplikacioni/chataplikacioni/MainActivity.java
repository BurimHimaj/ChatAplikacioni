package com.chataplikacioni.chataplikacioni;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {


    private Button kycu;
    private Button autoret;
    private Button admin;
    private Button regjistrohu;


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
                    }
                }
        );

        admin =  findViewById(R.id.admin);

        admin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent myIntent = new Intent(view.getContext(), Admin.class);
                        startActivity(myIntent);
                    }
                }
        );

        regjistrohu =  findViewById(R.id.regjistrohu);

        regjistrohu.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent myIntent = new Intent(view.getContext(), Regjistrohu.class);
                        startActivity(myIntent);
                    }
                }
        );
    }
}
