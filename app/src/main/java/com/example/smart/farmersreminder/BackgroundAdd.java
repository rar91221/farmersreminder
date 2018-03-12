package com.example.smart.farmersreminder;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Smart on 08-Mar-18.
 */

public class BackgroundAdd extends AsyncTask<String,String,String> {
    Context context;
    BackgroundAdd(Context ctx){
        context=ctx;
    }
    @Override

    protected String doInBackground(String... params) {

        String reg_url="http://192.168.43.2/phpproject/adminadd.php";
        String method=params[0];
        if(method.equals("addcrop"))
        {
            String crop=params[1];
            String breed=params[2];
            String season=params[3];
            String image=params[4];
            String day=params[5];
            String work=params[5];
            try {
                URL url=new URL(reg_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream os=httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));

                String data= URLEncoder.encode("crop","UTF-8")+"="+URLEncoder.encode(crop,"UTF-8")+"&"+
                        URLEncoder.encode("breed","UTF-8")+"="+URLEncoder.encode(breed,"UTF-8")+"&"+
                        URLEncoder.encode("season","UTF-8")+"="+URLEncoder.encode(season,"UTF-8")+"&"+
                        URLEncoder.encode("image","UTF-8")+"="+URLEncoder.encode(image,"UTF-8") +"&"+
                        URLEncoder.encode("day","UTF-8")+"="+URLEncoder.encode(day,"UTF-8") +"&"+
                        URLEncoder.encode("work","UTF-8")+"="+URLEncoder.encode(work,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();
                InputStream IS=httpURLConnection.getInputStream();
                IS.close();
                return "Add Successful";


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

