/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kesequl.app.network;

import com.kesequl.app.Login;
import com.kesequl.app.entity.User;
import com.kesequl.app.network.KesequlHttpRequest.Method;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.kesequl.app.util.function.JSONConverter;
import java.io.InputStream;
import java.util.Collection;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author user65
 */
public class Client {
    public static final String BASE_HOST = "https://kesequl.exposei.com/";
    public static final String HOST_API = BASE_HOST + "Api/";
    public static final String BASE_LAPORAN = BASE_HOST + "laporan/";
    public static final String HOST_LAPORAN_VOTING = BASE_LAPORAN + "voting/";
    
    public static final int CREATE = 1;
    public static final int READ = 2;
    public static final int UPDATE = 3;
    public static final int DELETE = 4;
    
    public static <T extends JSONConverter> void executeConnection(KesequlHttpRequest kesequlHttp, Class<T> _class, KesequlHttpCallback<T> callback) {
        executeConnection(true, kesequlHttp, _class, callback);
    }
    
    public static String getResultFromURL(KesequlHttpRequest kesequlHttp) {
        try {
            String paramGet = (kesequlHttp.getMethod() == Method.GET && kesequlHttp.getVal() != null && !kesequlHttp.getVal().isEmpty()) ? "?" + kesequlHttp.getVal() : "";
            HttpURLConnection con = (HttpURLConnection) URI.create(HOST_API + kesequlHttp.getUrl() + paramGet).toURL().openConnection();

            con.setRequestMethod(kesequlHttp.getMethod().getParam());
            con.setRequestProperty("Accept", "*/*");
            con.setUseCaches(false);

            if (kesequlHttp.getMethod() != Method.GET) {
                con.setDoOutput(true);
                con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                con.getOutputStream().write(kesequlHttp.getVal().getBytes());
                con.getOutputStream().flush();
                con.getOutputStream().close();
            } else {
                con.setDoInput(true);
            }
            
            String data = "";
            
            InputStream stream = con.getResponseCode() == 200 ? con.getInputStream() : con.getErrorStream();
            
            for (int c; (c = stream.read()) != -1;) {
                data += (char) c;
            }
            
            stream.close();
            
            return data;
        } catch (Exception ex) {
            return ex.toString();
        }
    }
    
    public static <T extends JSONConverter> void executeConnection(boolean async, KesequlHttpRequest kesequlHttp, Class<T> _class, KesequlHttpCallback<T> callback) {
        Runnable runnable = () -> {
            callback.onPrepare();
            try {
                String paramGet = (kesequlHttp.getMethod() == Method.GET && kesequlHttp.getVal() != null && !kesequlHttp.getVal().isEmpty()) ? "?" + kesequlHttp.getVal() : "";
                HttpURLConnection con = (HttpURLConnection) URI.create(HOST_API + kesequlHttp.getUrl() + paramGet).toURL().openConnection();
                
                con.setRequestMethod(kesequlHttp.getMethod().getParam());
                con.setRequestProperty("Accept", "application/json");
                con.setUseCaches(false);
                
                if (kesequlHttp.getMethod() != Method.GET) {
                    con.setDoOutput(true);
                    con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    con.getOutputStream().write(kesequlHttp.getVal().getBytes());
                    con.getOutputStream().flush();
                    con.getOutputStream().close();
                } else {
                    con.setDoInput(true);
                }
                
                InputStream stream = con.getResponseCode() == 200 ? con.getInputStream() : con.getErrorStream();
            
                String data = "";
                for (int c; (c = stream.read()) != -1;) {
                    data += (char) c;
                }
                
                stream.close();
                
                try {
                    JSONObject json = new JSONObject(data);

                    T entity = null;
                    if (_class != null) {
                        entity = _class.getDeclaredConstructor().newInstance();
                        if (json.optJSONObject("data") != null)
                            entity.fromJson(json.optJSONObject("data"));
                    }

                    callback.onSuccess(json.getInt("status"), json.getString("pesan"), entity);
                } catch (JSONException ex) {
                    System.err.println(data);
                    callback.onFailed(ex);
                }
            } catch (IOException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException ex) {
                ex.printStackTrace(System.err);
                callback.onFailed(ex);
            }
            
            callback.onDone();
        };
        
        if (async)
            new Thread(runnable).start();
        else
            runnable.run();
    }
    
    public static<T extends JSONConverter> void executeConnectionList(KesequlHttpRequest kesequlHttp, Class<T> _class, KesequlHttpCallback<List<T>> callback) {
        new Thread(() -> {
            callback.onPrepare();
            try {
                String paramGet = (kesequlHttp.getMethod() == Method.GET && kesequlHttp.getVal() != null && !kesequlHttp.getVal().isEmpty()) ? "?" + kesequlHttp.getVal() : "";
                HttpURLConnection con = (HttpURLConnection) URI.create(HOST_API + kesequlHttp.getUrl() + paramGet).toURL().openConnection();
                
                con.setRequestMethod(kesequlHttp.getMethod().getParam());
                con.setRequestProperty("Accept", "application/json");
                con.setUseCaches(false);
                
                if (kesequlHttp.getMethod() != Method.GET) {
                    con.setDoOutput(true);
                    con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    con.getOutputStream().write(kesequlHttp.getVal().getBytes());
                    con.getOutputStream().flush();
                    con.getOutputStream().close();
                } else {
                    con.setDoInput(true);
                }
                
                String data = "";
                InputStream stream = con.getResponseCode() == 200 ? con.getInputStream() : con.getErrorStream();
            
                for (int c; (c = stream.read()) != -1;) {
                    data += (char) c;
                }
                stream.close();
                
                try {
                    JSONObject json = new JSONObject(data);

                    JSONArray jsa = json.optJSONArray("data");
                    List<T> list = new ArrayList<>();

                    if (jsa != null) {
                        for (int i=0; i<jsa.length(); i++) {
                            T entity = _class.getDeclaredConstructor().newInstance();
                            if (jsa.getJSONObject(i) != null)
                                entity.fromJson(jsa.getJSONObject(i));

                            list.add(entity);
                        }
                    }

                    callback.onSuccess(json.getInt("status"), json.getString("pesan"), list);

                } catch (JSONException ex) {
                    System.err.println(data);
                    callback.onFailed(ex);
                }
            } catch (IOException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException ex) {
                callback.onFailed(ex);
            }
            callback.onDone();
        }).start();
    }
    
    public static boolean isTokenExpired(JFrame frame, int status, User user) {
        if (status == 3) {
            KesequlHttpRequest req = new KesequlHttpRequest(KesequlHttpRequest.Method.POST);
            req.setUrl("user/login");
            req.setVal("username=" + user.getUsername() + "&password=" + user.getPassword());
            class BoolVal {
                boolean val;
            }
            final BoolVal boolVal = new BoolVal();
            Client.executeConnection(req, User.class, new KesequlHttpCallback<User>() {
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
                        user.setAktif(data.isAktif());
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
            
            return boolVal.val;
        }
        
        return false;
    }
    
    public static void prepareVariable(User data) {
        Commands._extra.put("user:username", data.getUsername());
        Commands._extra.put("user:token", data.getToken());
    }
}
