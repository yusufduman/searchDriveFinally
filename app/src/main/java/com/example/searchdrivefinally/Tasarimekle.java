package com.example.searchdrivefinally;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Tasarimekle extends AppCompatActivity {

    private DatabaseHelper Veritabani;
    DatabaseHelper db;
    EditText cizimDokumanNumarasi, tasarimNumarasi, tasarimKayitEden, tasarimTipi;
    Button kayıtEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasarimekle);
        db = new DatabaseHelper(this);
        Veritabani = new DatabaseHelper(this);
        cizimDokumanNumarasi = (EditText) findViewById(R.id.cizimDokumanNumarasi);
        tasarimNumarasi = (EditText) findViewById(R.id.tasarimNumarasi);
        tasarimKayitEden = (EditText) findViewById(R.id.tasarimKayitEden);
        tasarimTipi = (EditText) findViewById(R.id.tasarimTipi);
        kayıtEt = (Button) findViewById(R.id.kayıtEt);
        kayıtEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    TasarimKayitEkle(cizimDokumanNumarasi.getText().toString(), tasarimNumarasi.getText().toString(), tasarimKayitEden.getText().toString(), tasarimTipi.getText().toString());
                }finally {
                    Veritabani.close();
                }
            }
        });
    }

    private void TasarimKayitEkle(String cizimDokumanNumarasi, String tasarimNumarasi, String tasarimKayitEden, String tasarimTipi){
        SQLiteDatabase db = Veritabani.getWritableDatabase();
        ContentValues tasarimlar = new ContentValues();
        tasarimlar.put("DokumanNumarasi",cizimDokumanNumarasi);
        tasarimlar.put("TasarimNumarasi",tasarimNumarasi);
        tasarimlar.put("TasarimKayitEden",tasarimKayitEden);
        tasarimlar.put("TasarimTipi",tasarimTipi);
        db.insertOrThrow("tbl_tasarim", null,tasarimlar);

    }
}
