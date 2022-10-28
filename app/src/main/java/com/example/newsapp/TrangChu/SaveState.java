package com.example.newsapp.TrangChu;

import android.content.Context;
import android.content.SharedPreferences;

public class SaveState {
    private Context context;
    private SharedPreferences sharedPreferences;

    public SaveState(Context context) {
        this.context = context;
        sharedPreferences=context.getSharedPreferences("preferences",Context.MODE_PRIVATE);
    }
    public void setState(boolean bvalue){
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean("bkey",bvalue);
        editor.apply();
    }
    public  boolean getState(){
        return sharedPreferences.getBoolean("bkey",false);
    }

}
