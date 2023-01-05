package com.example.prouasa1113417;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public final static String NAMA_DATABASE="CRUD_KHS";
    public final static String NAMA_TABEL="khs";
    public final static String field01="kodemk";
    public final static String field02="matakuliah";
    public final static String field03="sks";
    public final static String field04="nilai_angka";
    public final static String field05="nilai_huruf";
    public final static String field06="predikat";


    public DatabaseHelper(Context context) {
        super(context, NAMA_DATABASE,null, 1);
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+NAMA_TABEL+"(kodemk primary key,matakuliah text,sks text,nilai_angka text,nilai_huruf text, predikat text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+NAMA_TABEL);
        onCreate(db);
    }

    public boolean input_data(String xkodemk, String xmatkul, String xsks, String xangka, String xhuruf, String xpredikat) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(field01,xkodemk);
        contentValues.put(field02,xmatkul);
        contentValues.put(field03,xsks);
        contentValues.put(field04,xangka);
        contentValues.put(field05,xhuruf);
        contentValues.put(field06,xpredikat);

        db.insert(NAMA_TABEL,null,contentValues);
        return true;
    }

    public Cursor baca_data() {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cur = db.rawQuery("select * from " +NAMA_TABEL,null);
        return cur;
    }

    public boolean update_data(String xkodemk, String xmatkul, String xsks, String xangka, String xhuruf, String xpredikat) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(field01,xkodemk);
        contentValues.put(field02,xmatkul);
        contentValues.put(field03,xsks);
        contentValues.put(field04,xangka);
        contentValues.put(field05,xhuruf);
        contentValues.put(field06,xpredikat);

        long jadi = db.update(NAMA_TABEL, contentValues, "kodemk=?",new String[] {xkodemk});
        if(jadi>0) {
            return true;
        } else
        {
            return false;
        }

    }

    public void hapus_datamahasiswa(String xkodemk) {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(NAMA_TABEL, "kodemk=?",new String[]{xkodemk});
    }
}
