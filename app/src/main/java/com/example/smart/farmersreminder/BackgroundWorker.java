package com.example.smart.farmersreminder;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Smart on 02-Mar-18.
 */

public class BackgroundWorker extends AsyncTask<String,String,String> {
     Context context;
    BackgroundWorker(Context ctx){
        context=ctx;
    }
    @Override
    /*protected String doInBackground(String... params) {
        String url = "http://192.168.2.117/reg.php";
        try {
            URL url = new URL(url);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }*/
    protected String doInBackground(String... params) {

        String reg_url="http://192.168.43.2/phpproject/reg.php";
        String method=params[0];
        if(method.equals("registration"))
        {
            String fname=params[1];
            String lname=params[2];
            String mob=params[3];
            String username=params[4];
            String password=params[5];
            try {
                URL url=new URL(reg_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream os=httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));

                String data= URLEncoder.encode("fname","UTF-8")+"="+URLEncoder.encode(fname,"UTF-8")+"&"+
                        URLEncoder.encode("lname","UTF-8")+"="+URLEncoder.encode(lname,"UTF-8")+"&"+
                        URLEncoder.encode("mob","UTF-8")+"="+URLEncoder.encode(mob,"UTF-8")+"&"+
                        URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8") +"&"+
                        URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();
                InputStream IS=httpURLConnection.getInputStream();
                IS.close();
                return "Registration Successful";


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

   @Override
    protected void onPostExecute(String result) {

      //Toast.makeText(result,Toast.LENGTH_LONG).show();
       Toast.makeText(context,result,Toast.LENGTH_LONG).show();
    }

   @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }
}