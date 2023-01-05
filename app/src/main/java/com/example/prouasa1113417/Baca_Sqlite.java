package com.example.prouasa1113417;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Baca_Sqlite extends AppCompatActivity {
    RecyclerView recyclerView_sks;
    ArrayList<ModelMahasiswa> sksArrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baca_sqlite);
        recyclerView_sks=findViewById(R.id.recyclerviewsks);

        com.example.prouasa1113417.DatabaseHelper dbh= new com.example.prouasa1113417.DatabaseHelper(this);
        Cursor cursor=dbh.baca_data();

        cursor.moveToFirst();
        while (cursor.moveToNext()){
            sksArrayList.add(new ModelMahasiswa(cursor.getString(0),
                                                cursor.getString(1),
                                                cursor.getString(2),
                                                cursor.getString(3),
                                                cursor.getString(4),
                                                cursor.getString(5)));
        }
        AdapterMahasiswa adapterMahasiswa=new AdapterMahasiswa(this,sksArrayList);
        recyclerView_sks.setAdapter(adapterMahasiswa);
        recyclerView_sks.setLayoutManager(new LinearLayoutManager(this));


    }
}