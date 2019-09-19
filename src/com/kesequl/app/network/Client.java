/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kesequl.app.network;

import com.kesequl.app.Login;
import com.kesequl.app.entity.User;
import com.kesequl.app.network.KesequlHttpRequest.Method;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import com.kesequl.app.util.function.JSONConverter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author user65
 */
public class Client {
    // public static final String BASE_HOST = "https://kesequl.exposei.com/";
    public static final String BASE_HOST = "http://localhost/kesequl-alpha/";
    public static final String HOST_API = BASE_HOST + "Api/";
    public static final String HOST_ASSET = BASE_HOST + "assets/upload/";
    public static final String HOST_ASSET_IMAGE = HOST_ASSET + "image/";
    public static final String BASE_LAPORAN = BASE_HOST + "laporan/";
    public static final String HOST_LAPORAN_VOTING = BASE_LAPORAN + "voting/";
    
    public static final String executeGetResult(HttpEntity entity, KesequlHttpRequest request)throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpUriRequest uriRequest = null;
        if (request.getMethod() == Method.GET) {
            uriRequest = new HttpGet(request.getUrl());
        }
        else if(request.getMethod() == Method.POST) {
            HttpPost post = new HttpPost(request.getUrl());
            post.setEntity(entity);

            uriRequest = post;
        }
        String data = "";
        if (uriRequest != null) {
            HttpResponse response = client.execute(uriRequest);
            for (int c; (c = response.getEntity().getContent().read()) != -1;)
                data += (char) c;
        }
        
        return data;
    }
    
    public static final <T extends JSONConverter> void executeForResult(boolean async, HttpEntity entity, KesequlHttpRequest request, Class<T> _class, KesequlHttpCallback<T> _callback) {
        Runnable runnable = () -> {
            _callback.onPrepare();
            try {
                // Cara agar auto konek ke host api
                request.setUrl(HOST_API + request.getUrl());
                executeEntity(executeGetResult(entity, request), _class, new KesequlHttpCallback<T>() {
                    @Override
                    public void onSuccess(int status, String pesan, T data) {
                        _callback.onSuccess(status, pesan, data);
                    }

                    @Override
                    public void onFailed(Exception ex) {
                        _callback.onFailed(ex);
                    }
                });
            } catch (Exception ex) {
                _callback.onFailed(ex);
            }
            
            _callback.onDone();
        };
        
        if (async) new Thread(runnable).start();
        else runnable.run();
    }
    
    public static final <T extends JSONConverter> void executeForResultList(boolean async, HttpEntity entity, KesequlHttpRequest request, Class<T> _class, KesequlHttpCallback<T> _callback) {
        Runnable runnable = () -> {
            _callback.onPrepare();
            try {
                // Cara agar auto konek ke host api
                request.setUrl(HOST_API + request.getUrl());
                executeEntityList(executeGetResult(entity, request), _class, new KesequlHttpCallback<T>() {
                    @Override
                    public void onSuccess(int status, String pesan, T data) {
                        _callback.onSuccess(status, pesan, data);
                    }

                    @Override
                    public void onFailed(Exception ex) {
                        _callback.onFailed(ex);
                    }
                });
            } catch (Exception ex) {
                _callback.onFailed(ex);
            }
            
            _callback.onDone();
        };
        
        if (async) new Thread(runnable).start();
        else runnable.run();
    }
    
    public static final <T extends JSONConverter> void executeEntity(String strJson, Class<T> _class, KesequlHttpCallback<T> _callback) {
        _callback.onPrepare();
        
        try {
            if (!strJson.isEmpty()) {
                JSONObject json = new JSONObject(strJson);
                JSONObject dataEntity = json.optJSONObject("data");
                T entity = null;
                if (dataEntity != null) {
                    entity = _class.getDeclaredConstructor().newInstance();
                    entity.fromJson(dataEntity);
                }
                _callback.onSuccess(json.optInt("status", 0), json.optString("pesan", ""), entity);
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
            System.err.println(strJson);
            _callback.onFailed(ex);
        }
        
        _callback.onDone();
    }
    
    public static final <T extends JSONConverter> void executeEntityList(String strJson, Class<T> _class, KesequlHttpCallback<T> _callback) {
        _callback.onPrepare();
        
        try {
            if (!strJson.isEmpty()) {
                JSONObject json = new JSONObject(strJson);
                JSONArray dataEntity = json.optJSONArray("data");
                int status = json.optInt("status", 0);
                String pesan = json.optString("pesan" ,"");
                
                if (dataEntity != null) {
                    for (int i=0; i<dataEntity.length(); i++) {
                        JSONObject jsonItem = dataEntity.getJSONObject(i);
                        T entity = _class.getDeclaredConstructor().newInstance();
                        entity.fromJson(jsonItem);
                        
                        _callback.onSuccess(status, pesan, entity);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
            System.err.println(strJson);
            _callback.onFailed(ex);
        }
        
        _callback.onDone();
    }
    
    public static boolean isTokenExpired(JFrame frame, int status, User user) {
        if (status == 3) {
            KesequlHttpRequest req = new KesequlHttpRequest(KesequlHttpRequest.Method.POST);
            req.setUrl("user/login");
            class BoolVal {
                boolean val;
            }
            final BoolVal boolVal = new BoolVal();
            List<NameValuePair> params = new ArrayList<>();
            params.add(new BasicNameValuePair("username", user.getUsername()));
            params.add(new BasicNameValuePair("password", user.getPassword()));
            try {
                executeForResult(true, new UrlEncodedFormEntity(params), req, User.class, new KesequlHttpCallback<User>() {
                    @Override
                    public void onSuccess(int status, String pesan, User data) {
                        if(status == 0){
                            boolVal.val = true;
                            JOptionPane.showMessageDialog(frame, "Sesi Habis, Silahkan login kembali");
                            frame.dispose();
                            
                            new Login().setVisible(true);
                        } else if(status == 1){

                            user.setPerans(data.getPerans());
                            user.setToken(data.getToken());
                            user.setUang(data.getUang());
                            user.setEmail(data.getEmail());
                            user.setStatus(data.getStatus());
                            user.setKeterangan(data.getKeterangan());
                            user.setIdUser(data.getIdUser());

                            prepareVariable(user);

                            boolVal.val = false;
                        }
                    }

                    @Override
                    public void onFailed(Exception ex) {
                        JOptionPane.showMessageDialog(frame, ex.getMessage());
                        boolVal.val = true;
                    }
                });
            } catch (UnsupportedEncodingException ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage());
            }
            
            return boolVal.val;
        }
        
        return false;
    }
    
    public static void prepareVariable(User data) {
        Commands._extra.put("user:id", String.valueOf(data.getIdUser()));
        Commands._extra.put("user:username", data.getUsername());
        Commands._extra.put("user:token", data.getToken());
        Commands._extra.put("host:api", HOST_API);
        Commands._extra.put("host:base", BASE_HOST);
    }
}
