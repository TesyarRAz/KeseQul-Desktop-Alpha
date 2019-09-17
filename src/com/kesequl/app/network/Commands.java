/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kesequl.app.network;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author user65
 */
public class Commands {
    public static final Map<String, String> _extra = new HashMap<>();
    
    public static String[] parserInput(String input) {
        String[] data = input.split("\\s");

        String resultQ = "";
        String quoted = null;
        java.util.List<String> listses = new java.util.ArrayList<>();

        for (int i=0, state=0; i<data.length; i++) {
            int indexQOne = data[i].indexOf("\'");
            int indexQTwo = data[i].indexOf("\"");

            if (indexQOne != -1) {
                if (state == 0) {
                    if (indexQTwo != -1 && indexQOne < indexQTwo || indexQTwo == -1) {
                        quoted = "\'";
                        state = 1;
                        data[i] = data[i].replaceAll(quoted, "");
                    } else if (indexQTwo != -1) {
                        quoted = "\"";
                        state = 2;
                        data[i] = data[i].replaceAll(quoted, "");
                    }

                    resultQ += data[i] + " ";

                } else if (state == 1) {
                    quoted = null;
                    state = 0;
                    resultQ += data[i].replaceAll("\'", "");
                }

            } else if (indexQTwo != -1) {
                if (state == 0) {
                    if (indexQOne != -1 && indexQTwo < indexQOne || indexQOne == -1) {
                        quoted = "\"";
                        state = 2;
                        data[i] = data[i].replaceAll(quoted, "");
                    } else if (indexQOne != -1) {
                        quoted = "\'";
                        state = 1;
                        data[i] = data[i].replaceAll(quoted, "");
                    }
                    resultQ += data[i] + " ";
                } else if (state == 2) {
                    quoted = null;
                    state = 0;
                    resultQ += data[i].replaceAll("\"", "");
                }
            } else {
                if (!data[i].trim().isEmpty())
                    resultQ += data[i].trim() + " ";
            }

            if (quoted == null && state == 0 && !data[i].trim().isEmpty()) {
                listses.add(resultQ.trim());
                resultQ = "";
            }
        }
        
        return listses.toArray(new String[listses.size()]);
    }
    
    public static String commandResponse(String input) {
        String[] command = Commands.parserInput(input);
        
        switch (command[0].trim().toLowerCase()) {
            case "http":
                if (command.length < 3)
                    return "Command Gak Jelas";

                String method = getParamValue(command, "method");
                String url = getParamValue(command, "url");
                String val = getParamValue(command, "value");
                
                // GUNAKAN INI UNTUK PARSER VARIABLE, JANGAN DIPINDAH KE ATAS, INI INGATAN MASA LALU MU
                method = parserVariable(method);
                url = parserVariable(url);
                val = parserVariable(val);

                KesequlHttpRequest.Method M = null;
                HttpEntity entity = null;
                switch (method.toLowerCase()) {
                    case "get":
                        M = KesequlHttpRequest.Method.GET;
                        break;
                    case "post": {
                        M = KesequlHttpRequest.Method.POST;
                        List<NameValuePair> parameters = new ArrayList<>();
                        String[] params = val.split("&");
                        for (String param : params) {
                            String[] values = param.split("=");
                            String key = values[0];
                            String value = values[1];
                            
                            parameters.add(new BasicNameValuePair(key, value));
                        }
                        try {
                            entity = new UrlEncodedFormEntity(parameters);
                        } catch (Exception ex) {
                            return "Error : " + ex.getMessage();
                        }
                        break;
                    }
                    case "put":
                        M = KesequlHttpRequest.Method.PUT;
                        break;
                    case "delete":
                        M = KesequlHttpRequest.Method.DELETE;
                        break;
                }
                
                if (M == null)
                    return "Method tidak boleh kosong";
                else if(url == null)
                    return "Url tidak boleh kosong";

                try {
                    return Client.executeGetResult(entity, new KesequlHttpRequest(M, url));
                } catch (Exception ex) {
                    return ex.getMessage();
                }
            case "echo":
                String show = "";
                for (String com : Arrays.copyOfRange(command, 1, command.length))
                    show += com;
                
                show = parserVariable(show);
                
                if (show.isEmpty())
                    show = "\r\n";
                
                return show;
            case "set":
                String name = getParamValue(command, "name");
                String value = getParamValue(command, "value");
                
                if (name == null || name.isEmpty() || value == null || value.isEmpty())
                    return "Nama dan value tidak boleh kosong";
                
                _extra.put(name, value);
                
                return null;
            case "help":
                String query = command[1];
                switch (query) {
                    case "set":
                        return "set [-name= \'\'] [-value=\'\']";
                    case "http":
                        return "http [-url= \'\'] [-method=\'\'], Optional( -val=\'\' )";
                    case "echo":
                        return "echo [pesan] , Optional ($(variable-name))";
                }
        }
        
        return null;
    }
    
    public static String getParamValue(String commands[], String name) {
        for (String command : commands) {
            String com = command.substring(command.lastIndexOf("-") + 1);
            if (com.split("=")[0].toLowerCase().equals(name.toLowerCase())) {
                String result = com.substring(com.indexOf("=") + 1);
                
                return result.trim();
            }
        }
        
        return null;
    }
    
    public static final String parserVariable(String val) {
        if (val == null)
            return val;
        
        Iterator<String> iter = _extra.keySet().iterator();
        while (iter.hasNext()) {
            String _key = iter.next();
            val = val.replace("$(" + _key + ")", _extra.get(_key));
        }
        
        return val;
    }
}
