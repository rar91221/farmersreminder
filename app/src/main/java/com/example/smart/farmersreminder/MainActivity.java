package com.example.smart.farmersreminder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView newToRegister;
    Button b2;
    Button b1;
    EditText username;
    EditText password;
    String user;
    String pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  Intent reg=new Intent(MainActivity.this,adminadd.class);
        //startActivity(reg);
        setContentView(R.layout.login);
         username = (EditText) findViewById(R.id.editText1);
         password = (EditText) findViewById(R.id.editText2);
         Button button = (Button) findViewById(R.id.button1);
         button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                // String type="login";
                user = username.getText().toString().trim();
                pass = password.getText().toString().trim();
                if(!user.equals("")){
                    Log.i("User Name ::::: ", user);
                    Log.i("Pass Name ::::: ", pass);
                    BackgroundLogin w = new BackgroundLogin(MainActivity.this);
                    w.execute("login",user,pass);
                }
                //Log.i("User Name ::::: ", user);
                //Log.i("Pass Name ::::: ", pass);


            }
        });


        newToRegister = (TextView)findViewById(R.id.textView2);
        newToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setContentView(R.layout.registration);
                Intent reg=new Intent(MainActivity.this,registration.class);
                startActivity(reg);
            }
        });
    }
}
