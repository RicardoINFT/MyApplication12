package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Menu extends AppCompatActivity {
    MyDB sd ;
    public int ListaCarrinho(){
        sd = new MyDB(this);
        Cursor res = sd.getcoins();
        int s = 0;
        if (res.moveToFirst()) {
            s = res.getInt(0);
        }
        return s;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button bt1 = findViewById(R.id.button1mdnu);
        Button bt2 = findViewById(R.id.button5);
        Button btloja = findViewById(R.id.button4);
        TextView coins = findViewById(R.id.dinheiro);
        coins.setText(String.valueOf(ListaCarrinho()));
        sd = new MyDB(this);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound();
                Intent intent = new Intent(Menu.this, ChacterSelect.class);
                startActivity(intent);
            }
        });
        btloja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound();
                Intent intent = new Intent(Menu.this,loja.class);
                startActivity(intent);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound();
            }
        });
    }
    public void sound(){
        MediaPlayer player2 = MediaPlayer.create(this,R.raw.soundeffecr);
        player2.start();
    }
}