package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDB3 extends SQLiteOpenHelper {
    public MyDB3(Context context) {
        super(context, "assd2.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Utilizador(Id INTEGER primary key AUTOINCREMENT,name TEXT, dlc1 INTEGER,  dlc2 INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Utilizador");
        onCreate(DB);
    }
    public Boolean insertuserdata(String nomeprod, int dlc1,int dlc2) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", nomeprod);
        contentValues.put("dlc1", dlc1);
        contentValues.put("dlc2", dlc2);
        long result=DB.insert("Utilizador", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }
    public Cursor getdlc1() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select dlc1 from Utilizador", null);
        return cursor;
    }
    public Cursor getdlc2() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select dlc2 from Utilizador", null);
        return cursor;
    }
    //updatedlc1
    public Boolean updateDLC1(String nomeprod, int data) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("dlc1", data);
        DB.update("Utilizador", contentValues, "name=?", new String[]{"Ricardo"});
        return true;
    }
    //updatedlc2
    public Boolean updateDLC2(String nomeprod, int data) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("dlc2", data);
        DB.update("Utilizador", contentValues, "name=?", new String[]{"Ricardo"});
        return true;
    }
}
