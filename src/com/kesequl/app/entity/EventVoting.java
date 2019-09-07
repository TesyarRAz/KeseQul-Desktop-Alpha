/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kesequl.app.entity;

import com.kesequl.app.util.function.JSONConverter;
import java.time.LocalDate;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author user65
 */
public class EventVoting implements JSONConverter {
    
    private int idEventVoting;
    private int idPembuat;
    private String nama;
    private String password;
    private LocalDate tanggalMulai;
    private LocalDate tanggalSelesai;
    private boolean status;
    private String keterangan;

    public void setIdEventVoting(int idEventVoting) {
        this.idEventVoting = idEventVoting;
    }

    public void setIdPembuat(int idPembuat) {
        this.idPembuat = idPembuat;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTanggalMulai(LocalDate tanggalMulai) {
        this.tanggalMulai = tanggalMulai;
    }

    public void setTanggalSelesai(LocalDate tanggalSelesai) {
        this.tanggalSelesai = tanggalSelesai;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public int getIdEventVoting() {
        return idEventVoting;
    }

    public int getIdPembuat() {
        return idPembuat;
    }

    public String getNama() {
        return nama;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getTanggalMulai() {
        return tanggalMulai;
    }

    public LocalDate getTanggalSelesai() {
        return tanggalSelesai;
    }

    public boolean isStatus() {
        return status;
    }

    public String getKeterangan() {
        return keterangan;
    }

    @Override
    public void fromJson(JSONObject json) throws JSONException {
        idEventVoting = json.getInt("id_event_voting");
        idPembuat = json.getInt("id_pembuat");
        nama = json.getString("nama");
        password = json.getString("password");
        try {
            tanggalMulai = LocalDate.parse(json.getString("tanggal_mulai"));
            tanggalSelesai = LocalDate.parse(json.getString("tanggal_selesai"));
        } catch (Exception ex) {
            tanggalMulai = LocalDate.now();
            tanggalSelesai = LocalDate.now();
        }
        status = json.getInt("status")==1;
        keterangan = json.optString("keterangan");
    }
    
    
}
