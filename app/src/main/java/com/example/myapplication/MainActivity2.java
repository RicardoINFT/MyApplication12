package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class MainActivity2 extends AppCompatActivity {
    MyDB2 db2;
    public String date(){
        db2 = new MyDB2(this);
        Cursor res = db2.getcoins();

        String s = null;
        if (res.moveToFirst()) {
            s = res.getString(0);
        }
        return s;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);
        Bundle sw = getIntent().getExtras();
        VideoView simpleVideoView = (VideoView) findViewById(R.id.videoView);
        String videopath = "android.resource://" + getPackageName() + "/" + R.raw.introp;
        Uri u = Uri.parse(videopath);
        TextView s = findViewById(R.id.textView);
        simpleVideoView.setVideoURI(u);
        simpleVideoView.start();
        Date currentTime = Calendar.getInstance().getTime();
        db2 = new MyDB2(this);
        db2.insertuserdata("Ricardo",currentTime.toString());
        db2.updateuserdata("Ricardo",currentTime.toString());
        s.setText(date());
        Handler handler = new Handler();
        simpleVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (sw != null){
                    coisa2();
                }
                    else{coisa();}
            }
        });
        simpleVideoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sw != null){
                    coisa2();
                }
                else{coisa();}
            }
        })
    ;}
    public void coisa(){
                Intent intent = new Intent(MainActivity2.this, Menu.class);
                MediaPlayer player2 = MediaPlayer.create(this,R.raw.select);
                player2.start();
                startActivity(intent);
    }
    public void coisa2(){
        Intent intent = new Intent(MainActivity2.this, loja.class);
        startActivity(intent);
    }
}