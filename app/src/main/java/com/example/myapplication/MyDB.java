package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDB extends SQLiteOpenHelper {
    public MyDB( Context context) {
        super(context, "2222.db", null ,1);
    }
    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table User(Id INTEGER primary key AUTOINCREMENT, name TEXT, coins INTEGER, lvl INTEGER)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
        DB.execSQL("drop Table if exists User");
        onCreate(DB);
    }
    public Boolean insertuserdata(String nomeprod, int coins, int lvl) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", nomeprod);
        contentValues.put("coins", coins);
        contentValues.put("lvl", lvl);
        long result=DB.insert("User", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }
    //private boolean tableExists(SQLiteDatabase sqLiteDatabase, String User){
      //  if (sqLiteDatabase == null || !sqLiteDatabase.isOpen() || User == null){
        //    return false;
        //}
        //int count = 0;
        //String[] args = {"User",User};
        //Cursor cursor = sqLiteDatabase.rawQuery("SELECT COUNT(*) FROM User WHERE type=? AND name=?",args,null);
        //if (cursor.moveToFirst()){
          //  count = cursor.getInt(0);
        //}
        //cursor.close();
        //return insertuserdata("ricardo",0,1);
    //}
    public Cursor getcoins() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select coins from User", null);
        return cursor;
    }
    public Cursor getlvl() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select lvl from User", null);
        return cursor;
    }
    public Boolean updateuserdata(int coin, String nome) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("coins", coin);
        DB.update("User", contentValues, "name=?", new String[]{"ricardo"});
        return true;
    }
    public Boolean updateuserlvl(int lvl, String nome) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("lvl", lvl);
        DB.update("User", contentValues, "name=?", new String[]{"ricardo"});
        return true;
    }
}
