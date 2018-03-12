package com.example.smart.farmersreminder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * Created by Smart on 26-Feb-18.
 */

public class registration extends AppCompatActivity{
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        b1 = (Button)findViewById(R.id.button1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setContentView(R.layout.registration);
                EditText fnameET = (EditText)findViewById(R.id.editText1);
                String fname = fnameET.getText().toString();
                EditText lnameET = (EditText)findViewById(R.id.editText2);
                String lname = lnameET.getText().toString();
                EditText mobET = (EditText)findViewById(R.id.editText3);
                String mob = mobET.getText().toString();
                EditText userET = (EditText)findViewById(R.id.editText4);
                String username = userET.getText().toString();
                EditText passET = (EditText)findViewById(R.id.editText5);
                String password = passET.getText().toString();
                BackgroundWorker w = new BackgroundWorker(registration.this);
                w.execute("registration",fname,lname,mob,username,password);
                //finish();
                //Intent log=new Intent(registration.this,MainActivity.class);
                //startActivity(log);
            }
        });
    }
}
