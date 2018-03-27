package com.chataplikacioni.chataplikacioni;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by gimi on 3/27/2018.
 */

public class Admin extends AppCompatActivity {
    private Button btnkategori;
    private Button btnroli;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_panel);
        btnkategori = (Button) findViewById(R.id.btnkategori);

        btnkategori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), category.class);
                startActivity(myIntent);
            }
        });

        btnroli = (Button) findViewById(R.id.btnroli);
        btnroli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Roli.class);
                startActivity(myIntent);
            }
        });
    }
}
