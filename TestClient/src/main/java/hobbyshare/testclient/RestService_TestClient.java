/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hobbyshare.testclient;


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
    
    private String hostName = "http://localhost:";
    private String hostPort = "8095";
    
    
    public void test_Login(){
        HttpClient httpClient = HttpClientBuilder.create().build();
        
        String testURI = hostName + hostPort + "/login";
        
        JSONObject loginAttempt = new JSONObject();
        loginAttempt.put("password", "1234");
        loginAttempt.put("userName","77_username"); 

        try {
            HttpPost request = new HttpPost(testURI);
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
        
        String testURI = hostName + hostPort + "/get_User?userID=1";

        try {
            HttpGet request = new HttpGet(testURI);
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
