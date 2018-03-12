package com.example.smart.farmersreminder;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Smart on 04-Mar-18.
 */

public class BackgroundLogin extends AsyncTask<String,String,String> {

    Context context;
    AlertDialog alertDialog;
    BackgroundLogin(Context ctx){
        context=ctx;
    }
    @Override

    protected String doInBackground(String... params) {

        String type=params[0];
        String login_url = "http://192.168.43.2/phpproject/login.php";
        if(type.equals("login")){
            URL url;
            try {
                String user=params[1];
                String pass=params[2];
                Log.i("User Name ::::: ", user);
                Log.i("Pass Name ::::: ", pass);
                url = new URL(login_url);
                HttpURLConnection httpURLConnection =(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("user","UTF-8")+"="+URLEncoder.encode(user,"UTF-8")+
                        "&"+URLEncoder.encode("pass","UTF-8")+"="+URLEncoder.encode(pass,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while((line = bufferedReader.readLine())!=null){
                    result +=line;
                }

                bufferedWriter.close();
                outputStream.close();
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    @Override
    protected void onPreExecute() {

        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Login status");
    }

    @Override
    protected void onPostExecute(String result) {
        //alertDialog.setMessage(result);
        //alertDialog.show();
        Intent myIntent;
        if(result.equals("Admin Logged")){
            myIntent = new Intent(context,adminfirst.class);
            context.startActivity(myIntent);
        }else if(result.equals("User Logged")){
            myIntent=new Intent(context,activity_main.class);
            context.startActivity(myIntent);
        }else {
            alertDialog.setMessage(result);
            alertDialog.show();
        }
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }
}
