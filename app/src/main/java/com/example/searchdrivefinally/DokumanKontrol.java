package com.example.searchdrivefinally;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class DokumanKontrol extends AppCompatActivity {
    private DatabaseHelper Veritabani;
    DatabaseHelper db;
    EditText sorguDokuman;
    ListView sorguListe;
    Button sorguButon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dokuman_kontrol);
        db =  new DatabaseHelper(this);
        sorguDokuman = (EditText) findViewById(R.id.sorguDokuman);
        sorguListe = (ListView) findViewById(R.id.sorguListe);
        sorguButon = (Button) findViewById(R.id.sorguButon);
        /*sorguButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    SQLiteDatabase db = new Veritabani(getApplicationContext());
                    List<Kisiler> kisilerList = new ArrayList<Kisiler>();
                    kisilerList = vt.TumKayitlariGetir();
                    StringBuilder stringBuilder = new StringBuilder();
                    for(Kisiler kisiler : kisilerList){
                        stringBuilder.append(kisiler.getAd()+"\n"+kisiler.getSoyAd()+"\n\n");
                    }
                    tv.setText(stringBuilder);
                }
                catch(Exception e){
                    tv.setText("Kayıt Bulunamadı!"+e);
                }
            }
        }*/
        //sorgulamada denedim ancak bir türlü başlantısını yapamadım veri tabanı ile.
        );
    }

}
