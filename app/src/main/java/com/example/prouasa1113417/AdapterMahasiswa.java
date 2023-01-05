package com.example.prouasa1113417;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterMahasiswa extends RecyclerView.Adapter<AdapterMahasiswa.myViewHolder> {
    Context context;
    ArrayList <ModelMahasiswa> sksArrayList;

    public AdapterMahasiswa(Context context, ArrayList<ModelMahasiswa> sksArrayList) {
        this.context = context;
        this.sksArrayList = sksArrayList;
    }


    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.format_tampilan_mahasiswa,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.ckodemk.setText(sksArrayList.get(position).kodemk);
        holder.cmatakuliah.setText(sksArrayList.get(position).matakuliah);
        holder.csks.setText(sksArrayList.get(position).sks);
        holder.cangka.setText(sksArrayList.get(position).nilai_angka);
        holder.churuf.setText(sksArrayList.get(position).nilai_huruf);
        holder.cpredikat.setText(sksArrayList.get(position).predikat);


        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,updateDataMahasiswa.class);
                intent.putExtra("kodene",sksArrayList.get(position).kodemk);
                intent.putExtra("matkule",sksArrayList.get(position).matakuliah);
                intent.putExtra("skse",sksArrayList.get(position).sks);
                intent.putExtra("angkane",sksArrayList.get(position).nilai_angka);
                intent.putExtra("hurufe",sksArrayList.get(position).nilai_huruf);
                intent.putExtra("predikate",sksArrayList.get(position).predikat);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {return sksArrayList.size();}

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView ckodemk,cmatakuliah,csks,cangka,churuf, cpredikat;
        RelativeLayout relativeLayout;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            ckodemk=itemView.findViewById(R.id.akode);
            cmatakuliah=itemView.findViewById(R.id.amata);
            csks=itemView.findViewById(R.id.asks);
            cangka=itemView.findViewById(R.id.aangka);
            churuf=itemView.findViewById(R.id.ahuruf);
            cpredikat=itemView.findViewById(R.id.apredikat);
            relativeLayout=itemView.findViewById(R.id.rela01);

        }
    }
}
