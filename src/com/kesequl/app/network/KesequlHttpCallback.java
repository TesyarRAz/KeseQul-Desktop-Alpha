/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kesequl.app.network;

/**
 *
 * @author user65
 */
public interface KesequlHttpCallback<T> {
    public void onSuccess(int status, String pesan, T data);
    public void onFailed(Exception ex);
    
    default public void onPrepare() {}
    default public void onDone() {}
}
