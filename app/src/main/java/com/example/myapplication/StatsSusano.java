package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StatsSusano {
    private String nome;
    private int lvl;
    private int hp;
    private int dmg;
    private int dmgespecial;
    private int dmgultimate;
    private int mana;
    private int gold;

    public StatsSusano() {
        this.nome = "Susano";
        this.lvl = 18;
        this.hp = 700*getLvl();
        this.dmg = 240;
        this.gold = 0;
        this.mana = 650;
        this.dmgespecial = 400;
        this.dmgultimate = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = "Pantheon";
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public int getMana() {
        return mana;
    }
    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }
    public int getDmgespecial() {
        return dmgespecial;
    }

    public void setDmgespecial(int dmgespecial) {
        this.dmgespecial = dmgespecial;
    }

    public int getDmgultimate() {
        return dmgultimate;
    }

    public void setDmgultimate(int dmgultimate) {
        this.dmgultimate = dmgultimate;
    }

    public static class MyDB3 extends SQLiteOpenHelper {
        public MyDB3(Context context) {
            super(context, "loja.db", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase DB) {
            DB.execSQL("create Table loja(Id INTEGER primary key AUTOINCREMENT,item1 INTEGER,  item2 INTEGER)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
            DB.execSQL("drop Table if exists loja");
            onCreate(DB);
        }

        public Boolean insertuserdata(int item1, int item2) {
            SQLiteDatabase DB = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("item1", item1);
            contentValues.put("item2", item2);
            long result=DB.insert("loja", null, contentValues);
            if(result==-1){
                return false;
            }else{
                return true;
            }
        }


    }
}
