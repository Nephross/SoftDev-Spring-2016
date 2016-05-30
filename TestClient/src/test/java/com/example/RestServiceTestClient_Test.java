/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import hobbyshare.testclient.RestService_TestClient;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nephross
 */
public class RestServiceTestClient_Test {
    
    public RestServiceTestClient_Test() {
    }
    
    @Test
    public void Test_Method() {
        RestService_TestClient testClient = new RestService_TestClient();
        
        //testClient.testMethod();
        testClient.test_Login();
    }
    
}
