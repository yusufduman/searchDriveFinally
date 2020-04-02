package com.example.searchdrivefinally;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DokumanKontrol extends AppCompatActivity {
    private DatabaseHelper Veritabani;
    DatabaseHelper db;
    EditText sorguDokuman;
    ListView sorguListe;
    Button sorguButon;
    DokumanAdapter dokumanAdapter;
    private List<Map<String, String>> dokumanListesi = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dokuman_kontrol);
        dokumanAdapter = new DokumanAdapter(this, dokumanListesi);
        db =  new DatabaseHelper(this);
        sorguDokuman = (EditText) findViewById(R.id.sorguDokuman);
        sorguListe = (ListView) findViewById(R.id.sorguListe);
        sorguListe.setAdapter(dokumanAdapter);
        sorguButon = (Button) findViewById(R.id.btn_listele);
        sorguButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    DatabaseHelper db = new DatabaseHelper(getApplicationContext());
                    String dokumanNo = sorguDokuman.getText().toString();

                    dokumanListesi.clear();
                    dokumanListesi.addAll(db.KayitSorgula(dokumanNo));
                    dokumanAdapter.notifyDataSetChanged();

                    if(dokumanListesi.isEmpty()){
                        Toast.makeText(DokumanKontrol.this, "Döküman Bulunamadı!", Toast.LENGTH_SHORT).show();
                    }
                }
                catch(Exception e){

                }
            }
        }

        );
    }

}
