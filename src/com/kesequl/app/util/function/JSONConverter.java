/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kesequl.app.util.function;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author user65
 */
public interface JSONConverter {
    public void fromJson(JSONObject json) throws JSONException;
}
