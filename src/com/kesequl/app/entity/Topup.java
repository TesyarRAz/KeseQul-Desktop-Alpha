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
public class Topup implements JSONConverter {
    private int idTopup;
    private int idPengirim;
    private int idPenerima;
    private int bayar;
    private LocalDate waktu;
    private String keterengan;

    public void setIdTopup(int idTopup) {
        this.idTopup = idTopup;
    }

    public void setIdPengirim(int idPengirim) {
        this.idPengirim = idPengirim;
    }

    public void setIdPenerima(int idPenerima) {
        this.idPenerima = idPenerima;
    }

    public void setBayar(int bayar) {
        this.bayar = bayar;
    }

    public void setWaktu(LocalDate waktu) {
        this.waktu = waktu;
    }

    public void setKeterengan(String keterengan) {
        this.keterengan = keterengan;
    }

    public int getIdTopup() {
        return idTopup;
    }

    public int getIdPengirim() {
        return idPengirim;
    }

    public int getIdPenerima() {
        return idPenerima;
    }

    public int getBayar() {
        return bayar;
    }

    public LocalDate getWaktu() {
        return waktu;
    }

    public String getKeterengan() {
        return keterengan;
    }

    @Override
    public void fromJson(JSONObject json) throws JSONException {
        idTopup = json.getInt("id_topup");
        idPenerima = json.getInt("id_penerima");
        idPengirim = json.getInt("id_pengirim");
        bayar = json.getInt("bayar");
        waktu = LocalDate.parse(json.getString("waktu"));
        keterengan = json.optString("keterangan");
        
    }
    
}
