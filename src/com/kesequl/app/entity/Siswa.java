/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kesequl.app.entity;

import java.time.LocalDate;
import org.json.JSONException;
import org.json.JSONObject;
import com.kesequl.app.util.function.JSONConverter;

/**
 *
 * @author user65
 */
public class Siswa implements JSONConverter{
    private User user;
    private int idSiswa;
    private int nisn;
    private String nama;
    private char gender;
    private LocalDate ttl;
    private int kelas;
    private Jurusan jurusan;
    private int indexJurusan;
    private String keterangan;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getIdSiswa() {
        return idSiswa;
    }

    public void setIdSiswa(int idSiswa) {
        this.idSiswa = idSiswa;
    }

    public int getNisn() {
        return nisn;
    }

    public void setNisn(int nisn) {
        this.nisn = nisn;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public LocalDate getTtl() {
        return ttl;
    }

    public void setTtl(LocalDate ttl) {
        this.ttl = ttl;
    }

    public int getKelas() {
        return kelas;
    }

    public void setKelas(int kelas) {
        this.kelas = kelas;
    }

    public Jurusan getJurusan() {
        return jurusan;
    }

    public void setJurusan(Jurusan jurusan) {
        this.jurusan = jurusan;
    }

    public int getIndexJurusan() {
        return indexJurusan;
    }

    public void setIndexJurusan(int indexJurusan) {
        this.indexJurusan = indexJurusan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    @Override
    public void fromJson(JSONObject json) throws JSONException {
       idSiswa = json.getInt("id_siswa");
       nisn = json.getInt("nisn");
       nama = json.getString("nama");
       gender = json.getString("gender").charAt(0);
       kelas = json.getInt("kelas");
       indexJurusan = json.getInt("index_jurusan");
       keterangan = json.optString("keterangan");
       ttl = LocalDate.parse(json.getString("tanggal_lahir"));
       
       user = new User();
       user.fromJson(json);
       
       jurusan = new Jurusan();
       jurusan.fromJson(json);
    }
    
    
}
