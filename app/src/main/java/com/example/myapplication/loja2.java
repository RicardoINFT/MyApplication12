package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class loja2 extends AppCompatActivity {
    MyDB3 db;
    public int get(){
        Cursor res = db.getdlc1();
        int s = 0;
        if (res.moveToFirst()) {
            s = res.getInt(0);
        }
        return s;
    }
    public int get2(){
        Cursor res = db.getdlc2();
        int s = 0;
        if (res.moveToFirst()) {
            s = res.getInt(0);
        }
        return s;
    }
    MyDB db1;
    public int coins(){
        db1 = new MyDB(this);
        Cursor res = db1.getcoins();
        int s = 0;
        if (res.moveToFirst()) {
            s = res.getInt(0);
        }
        return s;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loja2);
        Button r = findViewById(R.id.button6);
        Button r1 = findViewById(R.id.dlc1);
        Button r2 = findViewById(R.id.dlc2);
        db = new MyDB3(this);
        //db.insertuserdata("Ricardo",0,0);
        if (get() == 1){
           r1.setEnabled(false);
        }
        if (get2() == 1) {
            r2.setEnabled(false);
        }

        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent n = new Intent(loja2.this,loja.class);
                startActivity(n);
            }
        });
        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (coins()<800){
                    Toast.makeText(loja2.this, "nada disso", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(loja2.this, "comprado", Toast.LENGTH_SHORT).show();
                    db1.updateuserdata(coins()-800,"ricardo");
                    db.updateDLC1("Ricardo",1);
                    r1.setEnabled(false);
                }
            }
        });
        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (coins()<300){
                    Toast.makeText(loja2.this, "nada disso", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(loja2.this, "comprado", Toast.LENGTH_SHORT).show();
                    db1.updateuserdata(coins()-300,"ricardo");
                    db.updateDLC2("Ricardo",1);
                    r2.setEnabled(false);
                }
            }
        });
    }
}