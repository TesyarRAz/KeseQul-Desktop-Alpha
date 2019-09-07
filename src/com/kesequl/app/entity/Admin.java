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
public class Admin implements JSONConverter {
    private int idAdmin;
    private int idUser;
    private String nama;
    private String keterangan;

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    
    @Override
    public void fromJson(JSONObject json) throws JSONException {
        idAdmin = json.getInt("id_admin");
        idUser = json.optInt("id_user");
        nama = json.getString("nama");
        keterangan = json.optString("keterangan");
    }
    
}
