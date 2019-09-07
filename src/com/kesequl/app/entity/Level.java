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
public class Level implements JSONConverter{
    private int idLevel;
    private String nama;
    private String keterangan;

    public void setIdLevel(int idLevel) {
        this.idLevel = idLevel;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public int getIdLevel() {
        return idLevel;
    }

    public String getNama() {
        return nama;
    }

    public String getKeterangan() {
        return keterangan;
    }

    @Override
    public void fromJson(JSONObject json) throws JSONException {
       nama = json.getString("nama");
       idLevel = json.getInt("id_level");
       keterangan = json.getString("keterangan");
       
    }
    
}
