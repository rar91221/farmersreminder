package com.example.smart.farmersreminder;

import java.util.ArrayList;

/**
 * Created by Smart on 14-Feb-18.
 */

public class Word {
    private String day;
    private String des;
    public String getDay()
    {
        return day;
    }
    public String getDes()
    {
        return des;
    }
    public Word(String day,String des)
    {
        this.day=day;
        this.des=des;

    }
}
