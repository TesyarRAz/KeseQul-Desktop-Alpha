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
public class Jurusan implements JSONConverter{
    private int idJurusan;
    private String nama;
    private String keterangan;

    public void setIdJurusan(int idJurusan) {
        this.idJurusan = idJurusan;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public int getIdJurusan() {
        return idJurusan;
    }

    public String getNama() {
        return nama;
    }

    public String getKeterangan() {
        return keterangan;
    }

    @Override
    public void fromJson(JSONObject json) throws JSONException {
        idJurusan = json.getInt("id_jurusan");
        nama = json.optString("nama_jurusan");
        
        keterangan = json.optString("keterangan");
    }
    
}
