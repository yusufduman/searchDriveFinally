package com.example.searchdrivefinally;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Hakkimizda extends AppCompatActivity {
    Button b1,b2,b3,b4,b5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hakkimizda);
        b1 = (Button)findViewById(R.id.yenidokuman);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap = new Intent(Hakkimizda.this, newDokuman.class);
                startActivity(gecisYap);
            }
        });
        b2 = (Button)findViewById(R.id.dokumankontrol);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap = new Intent(Hakkimizda.this, DokumanActivity.class);
                startActivity(gecisYap);
            }
        });
        b3 = (Button)findViewById(R.id.cizimekle);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap = new Intent(Hakkimizda.this, MainActivity.class);
                startActivity(gecisYap);
            }
        });
        b4 = (Button)findViewById(R.id.dokumannerede);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap = new Intent(Hakkimizda.this, MainActivity.class);
                startActivity(gecisYap);
            }
        });
        b5 = (Button)findViewById(R.id.kullanicipaneli);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap = new Intent(Hakkimizda.this, usercp.class);
                startActivity(gecisYap);
            }
        });

    }
}
