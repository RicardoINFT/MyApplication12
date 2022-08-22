package com.example.myapplication;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class loja extends AppCompatActivity {
    MyDB3 db;
    public int get(){
        Cursor res = db.getdlc1();
        int s = 0;
        if (res.moveToFirst()) {
            s = res.getInt(0);
        }
        return s;
    }
    public int get2() {
        Cursor res = db.getdlc2();
        int s = 0;
        if (res.moveToFirst()) {
            s = res.getInt(0);
        }
        return s;
    }
    MediaPlayer pl ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pl =  MediaPlayer.create(loja.this, R.raw.mainmenu);
        setContentView(R.layout.activity_loja);
        Button musica = findViewById(R.id.button2);
        Button ost1 = findViewById(R.id.btost1);
        Button ost2 = findViewById(R.id.btost2);
        Button loja = findViewById(R.id.button);
        Button intro = findViewById(R.id.intro);
        Button creditos = findViewById(R.id.creditos);
        Button on = findViewById(R.id.button10);
        Button dlc1 = findViewById(R.id.dlc1);
        Button dlc2 = findViewById(R.id.dlc2);
        db = new MyDB3(this);

        loja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent n = new Intent(loja.this,loja2.class);
                startActivity(n);
            }
        });
        on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent w = new Intent(loja.this,Menu.class);
                startActivity(w);
            }
        });
        creditos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent x = new Intent(loja.this, creditos.class);
                startActivity(x);
            }
        });
        musica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if (ost1.getVisibility() == View.INVISIBLE || ost2.getVisibility() == View.INVISIBLE ){
                ost1.setVisibility(View.VISIBLE);
                ost2.setVisibility(View.VISIBLE);
                    if (get() == 1){
                        dlc1.setVisibility(View.VISIBLE);
                    }
                    if (get2() == 1) {
                        dlc2.setVisibility(View.VISIBLE);
                    }
                }
            else {
                ost1.setVisibility(View.INVISIBLE);
                ost2.setVisibility(View.INVISIBLE);
                dlc1.setVisibility(View.INVISIBLE);
                dlc2.setVisibility(View.INVISIBLE);
                }
            }
        });
        dlc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pl.isPlaying()){
                    pl.stop();
                    pl = MediaPlayer.create(loja.this, R.raw.dlc1);
                    pl.start();
                }
                else{
                    pl = MediaPlayer.create(loja.this, R.raw.dlc1);
                    pl.start();
                }
            }
        });
        dlc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pl.isPlaying()){
                    pl.stop();
                    pl = MediaPlayer.create(loja.this, R.raw.dlc2);
                    pl.start();
                }
                else{
                    pl = MediaPlayer.create(loja.this, R.raw.dlc2);
                    pl.start();
                }
            }
        });
        ost1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pl.isPlaying()){
                    pl.stop();
                    pl = MediaPlayer.create(loja.this, R.raw.mainmenu);
                    pl.start();
                }
                else{
                    pl = MediaPlayer.create(loja.this, R.raw.mainmenu);
                    pl.start();
                }
            }
        });
        ost2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pl.isPlaying()){
                    pl.stop();
                    pl = MediaPlayer.create(loja.this, R.raw.select);
                    pl.start();
                }
                else{
                    pl = MediaPlayer.create(loja.this, R.raw.select);
                    pl.start();
                }
            }
        });
        intro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(loja.this,MainActivity2.class);
                intent.putExtra("asd","asd");
                startActivity(intent);
            }
        });
    }
}