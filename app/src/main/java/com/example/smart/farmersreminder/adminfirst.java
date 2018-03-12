package com.example.smart.farmersreminder;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Smart on 02-Mar-18.
 */

public class adminfirst extends AppCompatActivity {

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.adminfirst);
            Button b1 = (Button) findViewById(R.id.button1);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //setContentView(R.layout.registration);
                    Intent add=new Intent(adminfirst.this,adminadd.class);
                    startActivity(add);
                }
            });
        }*/
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminfirst);
        b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setContentView(R.layout.registration);
                Toast.makeText(adminfirst.this,"ENTERED",Toast.LENGTH_LONG).show();
                Intent add=new Intent(adminfirst.this,adminadd.class);
                startActivity(add);
            }
        });
    }

}

