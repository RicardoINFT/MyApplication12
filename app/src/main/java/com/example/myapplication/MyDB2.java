package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyDB2 extends SQLiteOpenHelper {
    public MyDB2(Context context) {
        super(context, "asd2.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Utilizador(Id INTEGER primary key AUTOINCREMENT, name TEXT,  data TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Utilizador");
        onCreate(DB);
    }
    public Boolean insertuserdata(String nomeprod, String data) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", nomeprod);
        contentValues.put("data", data);
        long result=DB.insert("Utilizador", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }
    public Cursor getcoins() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select data from Utilizador", null);
        return cursor;
    }
    public Boolean updateuserdata(String nomeprod, String data) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("data", data);
        DB.update("Utilizador", contentValues, "name=?", new String[]{"Ricardo"});
        return true;
    }
}
