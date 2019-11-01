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
public class Guru implements JSONConverter {
    private User user;
    private int idGuru;
    private int nip;
    private String nama;
    private char gender;
    private String imageLink;
    private LocalDate ttl;
    private String keterangan;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getIdGuru() {
        return idGuru;
    }

    public void setIdGuru(int idGuru) {
        this.idGuru = idGuru;
    }

    public int getNip() {
        return nip;
    }

    public void setNip(int nip) {
        this.nip = nip;
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

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    @Override
    public void fromJson(JSONObject json) throws JSONException {
        nama = json.getString("nama");
        ttl = LocalDate.parse(json.getString("tanggal_lahir"));
        gender = json.getString("gender").charAt(0);
        idGuru = json.getInt("id_guru");
        nip = json.getInt("nip");
        keterangan = json.optString("keterangan");
        imageLink = json.optString("image_link");
        
        user = new User();
        user.fromJson(json);
    }
}
