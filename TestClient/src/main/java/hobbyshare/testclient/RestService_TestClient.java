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
import java.net.URL;
import org.json.simple.JSONObject;

/**
 *
 * @author peter
 */
public class RestService_TestClient {
        
    public void testMethod(){
        String url="http://url.com";
        URL object=new URL(url);

        HttpURLConnection con = (HttpURLConnection) object.openConnection();
        con.setDoOutput(true);
        con.setDoInput(true);
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestMethod("POST");


        JSONObject cred = new JSONObject();
        JSONObject auth= new JSONObject();
        JSONObject parent= new JSONObject();
        cred.put("username","adm");
        cred.put("password", "pwd");
        auth.put("tenantName", "adm");
        auth.put("passwordCredentials", cred);
        parent.put("auth", auth);

        OutputStreamWriter wr= new OutputStreamWriter(con.getOutputStream());
        wr.write(parent.toString());
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
    }
}
