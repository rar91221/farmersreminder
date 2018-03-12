package com.example.smart.farmersreminder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Smart on 14-Feb-18.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(Context context,  ArrayList<Word> words){
        super(context,0,words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listitemView=convertView;
        if(listitemView==null)
        {
            listitemView= LayoutInflater.from(getContext()).inflate(R.layout.contentview,parent,false);
        }
        Word currentword=getItem(position);
        TextView day=(TextView) listitemView.findViewById(R.id.day);
        TextView des=(TextView) listitemView.findViewById(R.id.des);
        day.setText(currentword.getDay());
        des.setText(currentword.getDes());
        return listitemView;

    }



}
