package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {
    MyDB sd ;
    public int ListaCarrinho(){
        sd = new MyDB(this);
        Cursor res = sd.getlvl();
        int s = 0;
        if (res.moveToFirst()) {
            s = res.getInt(0);
        }
        return s;
    }
    public int guitos(){
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
        //region BTS And Stuff
        setContentView(R.layout.activity_main);
        Button bt = findViewById(R.id.basico);
        Button bt2 = findViewById(R.id.especial);
        Button bt3 = findViewById(R.id.ultimate);
        Button bt4 = findViewById(R.id.run);
        Button bt5 = findViewById(R.id.btiniciar);
        ImageView stage = findViewById(R.id.imageView13);
        TextView txtuse = findViewById(R.id.txtuser);
        TextView txtenemy = findViewById(R.id.txtenimigo);
        TextView txtnome = findViewById(R.id.txtnome);
        TextView txtlvl = findViewById(R.id.txtnivel);
        TextView nomenpc = findViewById(R.id.hpnpc);
        TextView txthp = findViewById(R.id.txtvida);
        GifImageView playergif = findViewById(R.id.gifImageView);
        GifImageView enemygif = findViewById(R.id.gifImageView2);
        TextView hpnpc = findViewById(R.id.vidanpc);
        TextView lvlnpc = findViewById(R.id.lvlnpc);
        hpnpc.setText(String.valueOf(statsminion.getHp()));
        lvlnpc.setText(String.valueOf(statsminion.getLvl()));
        bt3.setEnabled(false);
        bt2.setEnabled(false);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            playergif.setImageResource(R.drawable.kokonoestand);
            txtnome.setText("Kokonoe");
        }
        else{
            playergif.setImageResource(R.drawable.jinstance);
            txtnome.setText("Jin");
        }
        //endregion
        //Iniciar
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                statspanth.setLvl(ListaCarrinho());
                statspanth.setHp(580*statspanth.getLvl()/2);
                bt5.setEnabled(false);
                bt5.setVisibility(View.INVISIBLE);
                txtlvl.setText(String.valueOf(statspanth.getLvl()));
                txthp.setText(String.valueOf(statspanth.getHp()));
                Random random = new Random();
                int d = random.nextInt(30-0)+0;
                if (d==29 || d==1){
                    StatsSusano susano = new StatsSusano();
                    enemygif.setImageResource(R.drawable.susanostand);
                    hpnpc.setText(String.valueOf(susano.getHp()));
                    lvlnpc.setText(String.valueOf(susano.getLvl()));
                    danonpc = susano.getDmg();
                    stage.setImageResource(R.drawable.stagesusano);
                    nomenpc.setText(susano.getNome());
                }
                else if (d==15 || d==25){
                    Statstokoe toke = new Statstokoe();
                    enemygif.setImageResource(R.drawable.taokaka);
                    hpnpc.setText(String.valueOf(toke.getHp()));
                    lvlnpc.setText(String.valueOf(toke.getLvl()));
                    danonpc = toke.getDmg();
                    stage.setImageResource(R.drawable.takotostage);
                    nomenpc.setText(toke.getNome());
                }
                else{
                    enemygif.setImageResource(R.drawable.randomstand);
                    hpnpc.setText(String.valueOf(statsminion.getHp()));
                    lvlnpc.setText(String.valueOf(statsminion.getLvl()));
                    danonpc = statsminion.getDmg();
                    nomenpc.setText(statsminion.getNome());
                }
            }
        });
        //Bt AA
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Ataque
                int dmgnpc = statsminion.getDmg();
                int dmg = statspanth.getDmg();
                hpnpc.setText(String.valueOf(Integer.parseInt(hpnpc.getText().toString()) - dmg));
                txtuse.setText(txtnome.getText()+" usou ataque basico (Dmg -"+dmg+" )");
                txthp.setText(String.valueOf(Integer.parseInt(txthp.getText().toString()) - danonpc));
                txtenemy.setText(nomenpc.getText()+" deu dano (DMG -"+danonpc+")");
                stack[0] = stack[0] +1;
                stack();
                fimdejogo();
            }
        });
        //Bt special
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Ataque
                int dmg = statspanth.getDmgespecial();
                int dmgnpc = statsminion.getDmg();
                txthp.setText(String.valueOf(Integer.parseInt(txthp.getText().toString()) + dmg));
                txtuse.setText(txtnome.getText()+" usou ataque especial (Hp +"+dmg*statspanth.getLvl()/2+")");
                txtenemy.setText("Npc deu dano (DMG -"+danonpc+")");
                txthp.setText(String.valueOf(Integer.parseInt(txthp.getText().toString()) - danonpc));
                bt2.setEnabled(false);
                bt3.setEnabled(false);
                fimdejogo();
                stack[0] = stack[0]-2 ;
                stack();
            }
        });
        //Bt Ultimate
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Ataque
                Integer npc = Integer.parseInt(hpnpc.getText().toString());
                statspanth.setDmgultimate(npc/2);
                int dmg = statspanth.getDmgultimate();
                int dmgnpc = statsminion.getDmg();
                hpnpc.setText(String.valueOf(Integer.parseInt(hpnpc.getText().toString()) - dmg));
                txtuse.setText(txtnome.getText()+" usou ataque Ultimate (Dmg -"+dmg+" )");
                txtenemy.setText("Npc deu dano (DMG -"+danonpc+")");
                txthp.setText(String.valueOf(Integer.parseInt(txthp.getText().toString()) - danonpc));
                bt3.setEnabled(false);
                bt2.setEnabled(false);
                fimdejogo();
                stack[0]= stack[0]-3;
                stack();
            }
        });
        //Bt run
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Menu.class);
                startActivity(intent);
            }
        });
    }
    //region STUFF
    Statspanth statspanth = new Statspanth();
    statsminion statsminion = new statsminion();
    public int danonpc;
    public int nivel = 0;//receber da base de dados
    final Integer[] stack = {0};
    public void stack(){
        Button bt3 = findViewById(R.id.ultimate);
        Button bt2 = findViewById(R.id.especial);
        if (stack[0] >= 3) {
            bt3.setEnabled(true);
        }
        else if(stack[0] >= 2)
        {
            bt2.setEnabled(true);
        }
    }
    public void fimdejogo(){
        GifImageView playergif = findViewById(R.id.gifImageView);
        GifImageView enemygif = findViewById(R.id.gifImageView2);
        TextView hpuser = findViewById(R.id.txtvida);
        TextView hpnpc = findViewById(R.id.vidanpc);
        double npc = Double.parseDouble(hpnpc.getText().toString());
        double user = Double.parseDouble(hpuser.getText().toString());
        if(npc <= 0 && user <=0){
            hpnpc.setText("Morto");
            hpuser.setText("Morto");
            desabilitarbts();
            Toast.makeText(this, "Empate", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, Menu.class);
            Handler handler = new Handler();
            desabilitarbts();
            playergif.setImageResource(R.drawable.giphy);
            enemygif.setImageResource(R.drawable.giphy);
            handler.postDelayed(new Runnable() {
                public void run() {
                    startActivity(intent);
                    subirdenivel();
                }
            }, 5000);
        }
        else if(npc <= 0){
            hpnpc.setText("Morto");
            //statsminion.getLvl();
            sd.updateuserdata(guitos()+ statsminion.getLvl(),"ricardo");
            Intent intent = new Intent(MainActivity.this, Menu.class);
            Bundle extras = getIntent().getExtras();
            if(extras != null){
                playergif.setImageResource(R.drawable.kokonoewin2);
            }
            else{
                playergif.setImageResource(R.drawable.jinwin);
            }
            enemygif.setImageResource(R.drawable.giphy);
            Handler handler = new Handler();
            desabilitarbts();
            handler.postDelayed(new Runnable() {
                public void run() {
                    startActivity(intent);
                    subirdenivel();
                }
            }, 5000);
        }
        else if (user <= 0){
            hpuser.setText("morto");
            Toast.makeText(this, "Perdeste", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, Menu.class);

            TextView txtenemy = findViewById(R.id.hpnpc);
            playergif.setImageResource(R.drawable.giphy);

            if (txtenemy.getText().equals("Susano")){
            }
            else if (txtenemy.getText().equals("Taokaka")){
                enemygif.setImageResource(R.drawable.taotakawin);
            }
            else{
                enemygif.setImageResource(R.drawable.winrandom2);
            }
            desabilitarbts();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    startActivity(intent);
                }
            }, 5000);
        }

    }
    public void desabilitarbts(){
        Button bt = findViewById(R.id.basico);
        Button bt2 = findViewById(R.id.especial);
        Button bt3 = findViewById(R.id.ultimate);
        Button bt4 = findViewById(R.id.run);
        Button bt5 = findViewById(R.id.btiniciar);
        bt.setEnabled(false);
        bt2.setEnabled(false);
        bt3.setEnabled(false);
        bt4.setEnabled(false);
        bt5.setEnabled(false);
    };
    public void subirdenivel(){
        if (statsminion.getLvl() >= ListaCarrinho())
        {
            int i = ListaCarrinho() + 1;
            sd.updateuserlvl(i,"ricardo");
        }
    }
    //endregion

}