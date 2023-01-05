package com.example.prouasa1113417;

public class ModelMahasiswa {
    String kodemk;
    String matakuliah;
    String sks;
    String nilai_angka;
    String nilai_huruf;
    String predikat;

    public ModelMahasiswa(String kodemk, String matakuliah, String sks, String nilai_angka, String nilai_huruf, String predikat) {
        this.kodemk = kodemk;
        this.matakuliah = matakuliah;
        this.sks = sks;
        this.nilai_angka = nilai_angka;
        this.nilai_huruf = nilai_huruf;
        this.predikat = predikat;
    }

    public String getKodemk() {
        return kodemk;
    }

    public void setKodemk(String kodemk) {
        this.kodemk = kodemk;
    }

    public String getMatakuliah() {
        return matakuliah;
    }

    public void setMatakuliah(String matakuliah) {
        this.matakuliah = matakuliah;
    }

    public String getSks() {
        return sks;
    }

    public void setSks(String sks) {
        this.sks = sks;
    }

    public String getNilai_angka() {
        return nilai_angka;
    }

    public void setNilai_angka(String nilai_angka) {
        this.nilai_angka = nilai_angka;
    }

    public String getNilai_huruf() {
        return nilai_huruf;
    }

    public void setNilai_huruf(String nilai_huruf) {
        this.nilai_huruf = nilai_huruf;
    }

    public String getPredikat() {
        return predikat;
    }

    public void setPredikat(String predikat) {
        this.predikat = predikat;
    }
}
