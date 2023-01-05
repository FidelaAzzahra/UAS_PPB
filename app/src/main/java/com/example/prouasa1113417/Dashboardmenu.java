package com.example.prouasa1113417;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Dashboardmenu extends AppCompatActivity {

    Button tombolentry;
    Button tomboltampil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboardmenu);

        //ini untuk mengenali objek di dashboardmeru
        tombolentry = findViewById(R.id.button_entry);
        tomboltampil = findViewById(R.id.button_tampil);


        //ini untuk memanggil
        tombolentry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Dashboardmenu.this, EntryDataMahasiswa.class);
                startActivity(intent);
            }
        });

        //ini untuk memanggil
        tomboltampil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Dashboardmenu.this, Baca_Sqlite.class);
                startActivity(intent);
            }
        });


    }
}
