package com.example.prouasa1113417;

import android.content.Intent;
import android.os.Bundle;
import android.text.style.UpdateAppearance;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class updateDataMahasiswa extends AppCompatActivity implements View.OnClickListener {
    Button tombolupdate, tomboldelete;
    EditText ekodemk, ematkul, esks, eangka, ehuruf, epredikat;
    DatabaseHelper dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data_mahasiswa);
        ekodemk = findViewById(R.id.xkodemk);
        ematkul = findViewById(R.id.xmatkul);
        esks = findViewById(R.id.xsks);
        eangka = findViewById(R.id.xangka);
        ehuruf = findViewById(R.id.xhuruf);
        epredikat = findViewById(R.id.xpredikat);

        tombolupdate = findViewById(R.id.btnupdate);
        tomboldelete = findViewById(R.id.btndelete);

        tombolupdate.setOnClickListener(this);
        tomboldelete.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();

        ekodemk.setText(bundle.getString("kodene"));
        ematkul.setText(bundle.getString("matkule"));
        esks.setText(bundle.getString("skse"));
        eangka.setText(bundle.getString("angkane"));
        ehuruf.setText(bundle.getString("hurufe"));
        epredikat.setText(bundle.getString("predikate"));

        dbh = new DatabaseHelper(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnupdate)
        {
            //update
            String xkodemk =ekodemk.getText().toString();
            String xmatkul=ematkul.getText().toString();
            String xsks =esks.getText().toString();
            String xangka=eangka.getText().toString();
            String xhuruf=ehuruf.getText().toString();
            String xpredikat=epredikat.getText().toString();

            boolean oke= dbh.update_data(xkodemk, xmatkul, xsks, xangka, xhuruf, xpredikat);
            if(oke)
            {
                Toast.makeText(updateDataMahasiswa.this,"Update data berhasil", Toast.LENGTH_LONG).show();
                Intent intent=new Intent(updateDataMahasiswa.this,Baca_Sqlite.class);
                startActivity(intent);
            } else {
                Toast.makeText(updateDataMahasiswa.this, "Update data gagal", Toast.LENGTH_LONG).show();
            }
            Intent intent=new Intent(updateDataMahasiswa.this, Baca_Sqlite.class);
            startActivity(intent);

            //delete
        } else if (view.getId() == R.id.btndelete) {
            String xkodemk = ekodemk.getText().toString();
            dbh.hapus_datamahasiswa(xkodemk);
            Intent intent=new Intent(updateDataMahasiswa.this, Baca_Sqlite.class);
            startActivity(intent);

        } else {
            Intent intent=new Intent(updateDataMahasiswa.this, Baca_Sqlite.class);
            startActivity(intent);
        }

    }
}