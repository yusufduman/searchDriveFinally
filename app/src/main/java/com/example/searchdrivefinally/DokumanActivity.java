package com.example.searchdrivefinally;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Map;


public class DokumanActivity extends AppCompatActivity {
    private DatabaseHelper Veritabani;
    EditText text_dokumannumarasi2, deneme;
    TextView text_dokumansevk, text_dokumannumarasi, text_dokumantipi, text_kayiteden;
    Button btn_kayitet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dokuman);
        Veritabani = new DatabaseHelper(this);
        text_dokumannumarasi = (TextView) findViewById(R.id.text_dokumannumarasi);
        text_dokumannumarasi = (TextView) findViewById(R.id.text_dokumannumarasi);
        text_dokumantipi = (TextView) findViewById(R.id.text_dokumantipi);
        text_dokumansevk = (TextView) findViewById(R.id.text_dokumansevk);
        text_kayiteden = (TextView) findViewById(R.id.text_kayiteden);
        text_dokumannumarasi2 = (EditText) findViewById(R.id.text_dokumannumarasi2);
        btn_kayitet = (Button) findViewById(R.id.btn_kayitet);
        btn_kayitet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Map<String, String> stringStringMap = Veritabani.KayitSorgula(text_dokumannumarasi2.getText().toString());
                    if(stringStringMap!=null){
                        text_dokumannumarasi.setText(stringStringMap.get("DokumanNumarasi"));
                        text_dokumantipi.setText(stringStringMap.get("DokumanTipi"));
                        text_dokumansevk.setText(stringStringMap.get("DokumanSevkTarihi"));
                        text_kayiteden.setText(stringStringMap.get("DokumanKayitEden"));
                    }

                }finally {
                    Veritabani.close();
                }
            }
        });
    }







}