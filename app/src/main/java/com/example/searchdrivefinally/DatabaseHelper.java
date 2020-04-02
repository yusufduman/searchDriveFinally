package com.example.searchdrivefinally;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ListView;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context, "Veritabani.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(email text primary key, password text)");
        db.execSQL("Create table tbl_dokuman(DokumanNumarasi text, DokumanTipi text, DokumanSevkTarihi text, DokumanKayitEden text)");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("drop table if exists user");
    db.execSQL("drop table if exists tbl_dokuman");
    }
    public boolean insert(String email,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password);
        long ins = db.insert("user",null,contentValues);
        if(ins==-1)return false;
        else return true;
    }
    public Boolean checkemail(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where email=?",new String[] {email});
        if(cursor.getCount()>0) return false;
        else return true;
    }
    public Boolean emailpassword(String email, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where email=? and password=?",new String[]{email,password});
        if(cursor.getCount()>0)return true;
        else return false;
    }

    public List<Map<String, String>> KayitSorgula(String dokumanNumarasi) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from tbl_dokuman where DokumanNumarasi=?", new String[]{dokumanNumarasi});

        List<Map<String, String>> dokumanListesi = new ArrayList<>();

        while (cursor.moveToNext()){
            HashMap<String, String> dokuman = new HashMap<>();
            dokuman.put("DokumanNumarasi", cursor.getString(0));
            dokuman.put("DokumanTipi", cursor.getString(1));
            dokuman.put("DokumanSevkTarihi", cursor.getString(2));
            dokuman.put("DokumanKayitEden", cursor.getString(3));

            dokumanListesi.add(dokuman);
        }

        return dokumanListesi;
    }

}
