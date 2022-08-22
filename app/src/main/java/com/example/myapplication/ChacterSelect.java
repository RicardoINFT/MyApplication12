package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ChacterSelect extends AppCompatActivity {
    ImageButton bt1,bt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chacter_select);
        bt2 = findViewById(R.id.kokonoaicon);
        bt1 = findViewById(R.id.jinicon);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChacterSelect.this, MainActivity.class);
                String strnome = "kokonoe";
                intent.putExtra("kokonoe", strnome);
                startActivity(intent);
            }
        });
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChacterSelect.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}