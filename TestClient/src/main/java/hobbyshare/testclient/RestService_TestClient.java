/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hobbyshare.testclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;

/**
 *
 * @author peter
 */
public class RestService_TestClient {
        
    public void testMethod(){
        String url="http://localhost:8095/login";
        URL object;
        try {
            object = new URL(url);
        

        HttpURLConnection con = (HttpURLConnection) object.openConnection();
        con.setDoOutput(true);
        con.setDoInput(true);
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestMethod("POST");


        JSONObject loginAttempt = new JSONObject();
        loginAttempt.put("password", "1234");
        loginAttempt.put("userName","77_username");
        
        System.out.println(loginAttempt);
        
        System.out.println("Firing the JSON");
        
        OutputStreamWriter wr= new OutputStreamWriter(con.getOutputStream());
        wr.write(loginAttempt.toString());
        wr.flush();

        //display what returns the POST request

        StringBuilder sb = new StringBuilder();  
        int HttpResult = con.getResponseCode(); 
        if (HttpResult == HttpURLConnection.HTTP_OK) {
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
            String line = null;  
            while ((line = br.readLine()) != null) {  
                sb.append(line + "\n");  
            }
            br.close();
            System.out.println("" + sb.toString());  
        } else {
            System.out.println(con.getResponseMessage());  
        }
        
        } catch (MalformedURLException ex) {
            Logger.getLogger(RestService_TestClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (Exception e) {
            Logger.getLogger(RestService_TestClient.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
