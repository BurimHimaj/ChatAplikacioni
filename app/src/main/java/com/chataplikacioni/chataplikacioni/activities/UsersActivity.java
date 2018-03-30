package com.chataplikacioni.chataplikacioni.activities;

/**
 * Created by User on 3/27/2018.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.chataplikacioni.chataplikacioni.R;

public class UsersActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView gjenekologId, neurologId, kirurgId, psikiaterId, pediaterId, kardiologId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        getSupportActionBar().hide();
        gjenekologId = (CardView) findViewById(R.id.gjenekologId);
        neurologId = (CardView) findViewById(R.id.neurologId);
        kirurgId = (CardView) findViewById(R.id.kirurgId);
        psikiaterId = (CardView) findViewById(R.id.psikiaterId);
        pediaterId = (CardView) findViewById(R.id.pediaterId);
        kardiologId = (CardView) findViewById(R.id.kardiologId);

        gjenekologId.setOnClickListener(this);
        neurologId.setOnClickListener(this);
        kirurgId.setOnClickListener(this);
        psikiaterId.setOnClickListener(this);
        pediaterId.setOnClickListener(this);
        kardiologId.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.gjenekologId: i = new Intent(this,Gjenekolog.class); startActivity(i); break;
            case R.id.neurologId : i = new Intent(this,Neurolog.class); startActivity(i);break;
            case R.id.kirurgId : i = new Intent(this,Kirurg.class); startActivity(i);break;
            case R.id.psikiaterId : i = new Intent(this,Psikiater.class); startActivity(i);break;
            case R.id.pediaterId : i = new Intent(this,Pediater.class); startActivity(i);break;
            case R.id.kardiologId : i = new Intent(this,Kardiolog.class); startActivity(i);break;

            default:break;

        }
    }
}

