package com.example.prouasa1113417;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EntryDataMahasiswa extends AppCompatActivity {

    EditText ckode,cmatkul,csks,cangka, churuf, cpredikat;
    Button btnsave,btncancel;
    DatabaseHelper dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_data_mahasiswa);

        ckode=findViewById(R.id.xkodemk);
        cmatkul=findViewById(R.id.xmatkul);
        csks=findViewById(R.id.xsks);
        cangka=findViewById(R.id.xangka);
        churuf=findViewById(R.id.xhuruf);
        cpredikat=findViewById(R.id.xpredikat);

        btnsave=findViewById(R.id.btnsave);
        btncancel = findViewById(R.id.btncancle);

        //ini untuk memanggil
        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(EntryDataMahasiswa.this, Dashboardmenu.class);
                startActivity(intent);
            }
        });

        dbh=new DatabaseHelper(this);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String xkodemk=ckode.getText().toString();
                String xmatkul=cmatkul.getText().toString();
                String xsks=csks.getText().toString();
                String xangka=cangka.getText().toString();
                String xhuruf=churuf.getText().toString();
                String xpredikat=cpredikat.getText().toString();

                boolean hasil= dbh.input_data(xkodemk,xmatkul,xsks,xangka,xhuruf,xpredikat);
                if (hasil)
                {
                    Toast.makeText(EntryDataMahasiswa.this, "Data Tersimpan",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}