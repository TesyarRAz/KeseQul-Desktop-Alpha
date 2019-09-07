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
public class KesequlHttpRequest {
    public static enum Method {
        POST("POST"), GET("GET"), PUT("PUT"), DELETE("DELETE");
        
        private final String param;
        Method(String param) {
            this.param = param;
        }

        public String getParam() {
            return param;
        }
        
    }
    
    private String url;
    private Method method;
    private String _val;

    public KesequlHttpRequest(Method method) {
        this(method, null, null);
    }
    
    public KesequlHttpRequest(String url) {
        this(null, url, null);
    }
    
    public KesequlHttpRequest(Method method, String url) {
        this(method, url, null);
    }
    
    public KesequlHttpRequest(Method method, String url, String _val) {
        this.url = url;
        this.method = method;
        this._val = _val;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVal() {
        return _val;
    }

    public void setVal(String _val) {
        this._val = _val;
    }
    
}
