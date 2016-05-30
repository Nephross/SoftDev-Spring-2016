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
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;

/**
 *
 * @author peter
 */
public class RestService_TestClient {
       
    public void test_Login(){
        HttpClient httpClient = HttpClientBuilder.create().build();
        
        JSONObject loginAttempt = new JSONObject();
        loginAttempt.put("password", "1234");
        loginAttempt.put("userName","77_username"); 

        try {
            HttpPost request = new HttpPost("http://localhost:8095/login");
            StringEntity params = new StringEntity(loginAttempt.toString());
            request.addHeader("content-type", "application/json");
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);

            System.out.println("---Testing Login----");
            System.out.println(response.toString());
            HttpEntity entity = response.getEntity();
            String responseString = EntityUtils.toString(entity, "UTF-8");
            System.out.println(responseString);
            System.out.println("----End of login Test----");
        }catch (Exception ex) {
            // handle exception here
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
    }
    
    public void test_GetUserProfile() {
        HttpClient httpClient = HttpClientBuilder.create().build();
        

        try {
            HttpGet request = new HttpGet("http://localhost:8095/get_User?userID=1");
            HttpResponse response = httpClient.execute(request);

            System.out.println("---Testing getUserProfile----");
            System.out.println(response.toString());
            HttpEntity entity = response.getEntity();
            String responseString = EntityUtils.toString(entity, "UTF-8");
            System.out.println(responseString);
            System.out.println("---End of getUserProfile test----");
            
        }catch (Exception ex) {
            // handle exception here
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
    }
    
}
