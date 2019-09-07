/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kesequl.app.entity;

import org.json.JSONException;
import org.json.JSONObject;
import com.kesequl.app.util.function.JSONConverter;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/**
 *
 * @author user65
 */
public class User implements JSONConverter{
    private int idUser;
    private String username;
    private String password;
    private String email;
    private String token;
    private boolean aktif;
    private String keterangan;
    private int uang;
    private List<Peran> perans = new ArrayList<>();
    
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAktif() {
        return aktif;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setAktif(boolean aktif) {
        this.aktif = aktif;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public int getUang() {
        return uang;
    }

    public void setUang(int uang) {
        this.uang = uang;
    }

    public List<Peran> getPerans() {
        return perans;
    }

    public void setPerans(List<Peran> perans) {
        this.perans = perans;
    }

    @Override
    public void fromJson(JSONObject json) throws JSONException {
        aktif = json.optInt("aktif") == 1;
        idUser = json.optInt("id_user");
        username = json.optString("username");
        token = json.optString("token");
        email = json.optString("email");
        uang = json.optInt("uang");
        keterangan = json.optString("keterangan");
        
        JSONArray arr_peran = json.optJSONArray("peran");
        if (arr_peran != null) {
            for (int i=0; i<arr_peran.length(); i++) {
                Peran peran = new Peran();
                peran.fromJson(arr_peran.getJSONObject(i));
                
                perans.add(peran);
            }
        }
    }
}
