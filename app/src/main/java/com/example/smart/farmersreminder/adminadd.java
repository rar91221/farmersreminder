package com.example.smart.farmersreminder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import static com.example.smart.farmersreminder.R.id.imageView;


/**
 * Created by Smart on 02-Mar-18.
 */

public class adminadd extends AppCompatActivity{
    private static final int PICK_IMAGE =100;
    Uri imageuri;
    ImageView imageView;
    Button butt;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.adminadd);
            imageView = (ImageView) findViewById(R.id.imageView1);
            butt = (Button) findViewById(R.id.button3);
            butt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openGallery();

                }
            });
            EditText cropET = (EditText)findViewById(R.id.editText1);
            String crop = cropET.getText().toString();
            EditText breedET = (EditText)findViewById(R.id.editText2);
            String breed = breedET.getText().toString();
            EditText seasonET = (EditText)findViewById(R.id.editText3);
            String season = seasonET.getText().toString();
            ImageView imageET = (ImageView) findViewById(R.id.imageView1);
           // String image = imageET.
            EditText dayET = (EditText)findViewById(R.id.editText4);
            String day = dayET.getText().toString();
            EditText workET = (EditText)findViewById(R.id.editText5);
            String work = workET.getText().toString();
            BackgroundAdd w = new BackgroundAdd(adminadd.this);
           // w.execute("addcrop",crop,breed,season,image,day,work);
        }
        private void openGallery(){
            Intent gallery= new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
            startActivityForResult(gallery,PICK_IMAGE);
        }
    @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if (resultCode==RESULT_OK && requestCode == PICK_IMAGE) {
            imageuri=data.getData();
            imageView.setImageURI(imageuri);
        }
    }

    }


