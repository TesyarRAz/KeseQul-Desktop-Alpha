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
public class Peran implements JSONConverter {
    private int idPeran;
    private int idUser;
    private int idLevel;
    private String namaLevel;
    private int idPengizin;

    public int getIdPeran() {
        return idPeran;
    }

    public void setIdPeran(int idPeran) {
        this.idPeran = idPeran;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdLevel() {
        return idLevel;
    }

    public void setIdLevel(int idLevel) {
        this.idLevel = idLevel;
    }

    public String getNamaLevel() {
        return namaLevel;
    }

    public void setNamaLevel(String namaLevel) {
        this.namaLevel = namaLevel;
    }

    public int getIdPengizin() {
        return idPengizin;
    }

    public void setIdPengizin(int idPengizin) {
        this.idPengizin = idPengizin;
    }
    
    @Override
    public void fromJson(JSONObject json) throws JSONException {
        idPeran = json.getInt("id_peran");
        idLevel = json.getInt("id_level");
        namaLevel = json.optString("nama_level");
        idUser = json.optInt("id_user");
        idPengizin = json.optInt("id_pengizin");
    }
    
}
