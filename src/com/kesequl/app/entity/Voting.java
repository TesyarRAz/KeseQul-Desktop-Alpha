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
public class Voting implements JSONConverter{
    private int idVoting;
    private int idEventVoting;
    private int idPemilih;
    private int idNominasiTeam;
    private LocalDate waktuPilih;
    private String keterangan;

    public void setIdVoting(int idVoting) {
        this.idVoting = idVoting;
    }

    public void setIdEventVoting(int idEventVoting) {
        this.idEventVoting = idEventVoting;
    }

    public void setIdPemilih(int idPemilih) {
        this.idPemilih = idPemilih;
    }

    public void setIdNominasiTeam(int idNominasiTeam) {
        this.idNominasiTeam = idNominasiTeam;
    }

    public void setWaktuPilih(LocalDate waktuPilih) {
        this.waktuPilih = waktuPilih;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public int getIdVoting() {
        return idVoting;
    }

    public int getIdEventVoting() {
        return idEventVoting;
    }

    public int getIdPemilih() {
        return idPemilih;
    }

    public int getIdNominasiTeam() {
        return idNominasiTeam;
    }

    public LocalDate getWaktuPilih() {
        return waktuPilih;
    }

    public String getKeterangan() {
        return keterangan;
    }

    @Override
    public void fromJson(JSONObject json) throws JSONException {
        
        idVoting = json.getInt("id_voting");
        idEventVoting = json.getInt("id_event_voting");
        idPemilih = json.getInt("id_pemilih");
        idNominasiTeam = json.getInt("id_nominasi_team");
        waktuPilih = LocalDate.parse("waktu_pilih");
        keterangan = json.optString("keterangan");
    }
}
