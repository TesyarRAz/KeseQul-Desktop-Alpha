/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kesequl.app.entity;

import com.kesequl.app.util.function.JSONConverter;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author user65
 */
public class NominasiTeam implements JSONConverter{
    
    private int idNominasiTeam;
    private int idEventVoting;
    private String nama;
    private int idKetua;
    private String namaKetua;
    private String kelasKetua;
    private int idWakil;
    private String namaWakil;
    private String kelasWakil;
    private String visi;
    private String misi;
    private String keterangan;

    public int getIdNominasiTeam() {
        return idNominasiTeam;
    }

    public void setIdNominasiTeam(int idNominasiTeam) {
        this.idNominasiTeam = idNominasiTeam;
    }

    public int getIdEventVoting() {
        return idEventVoting;
    }

    public void setIdEventVoting(int idEventVoting) {
        this.idEventVoting = idEventVoting;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getIdKetua() {
        return idKetua;
    }

    public void setIdKetua(int idKetua) {
        this.idKetua = idKetua;
    }

    public String getNamaKetua() {
        return namaKetua;
    }

    public void setNamaKetua(String namaKetua) {
        this.namaKetua = namaKetua;
    }

    public String getKelasKetua() {
        return kelasKetua;
    }

    public void setKelasKetua(String kelasKetua) {
        this.kelasKetua = kelasKetua;
    }

    public int getIdWakil() {
        return idWakil;
    }

    public void setIdWakil(int idWakil) {
        this.idWakil = idWakil;
    }

    public String getNamaWakil() {
        return namaWakil;
    }

    public void setNamaWakil(String namaWakil) {
        this.namaWakil = namaWakil;
    }

    public String getKelasWakil() {
        return kelasWakil;
    }

    public void setKelasWakil(String kelasWakil) {
        this.kelasWakil = kelasWakil;
    }

    public String getVisi() {
        return visi;
    }

    public void setVisi(String visi) {
        this.visi = visi;
    }

    public String getMisi() {
        return misi;
    }

    public void setMisi(String misi) {
        this.misi = misi;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    @Override
    public void fromJson(JSONObject json) throws JSONException {
        idNominasiTeam = json.getInt("id_nominasi_team");
        idEventVoting = json.getInt("id_event_voting");
        nama = json.getString("nama");
        idKetua = json.getInt("id_ketua");
        namaKetua = json.getString("nama_ketua");
        kelasKetua = json.getString("kelas_ketua");
        idWakil = json.getInt("id_wakil");
        namaWakil = json.getString("nama_wakil");
        kelasWakil = json.getString("kelas_wakil");
        visi = json.getString("visi");
        misi = json.getString("misi");
        keterangan = json.optString("keterangan");
    }
    
}
