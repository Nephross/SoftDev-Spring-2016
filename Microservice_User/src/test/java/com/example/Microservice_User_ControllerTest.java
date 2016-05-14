package com.example;

import Domain.User;
import Domain.User_CreateUser;
import com.amazonaws.util.json.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

import microservice_User.Microservice_User_Application;
import microservice_User.Microservice_User_Controller;
import microservice_User.Repository.UserRepository;
import microservice_User_DBWrapper.DBWrapper;
import org.apache.commons.lang.exception.ExceptionUtils;

import static org.hamcrest.Matchers.is;

import org.junit.Assert;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Microservice_User_Application.class)
public class Microservice_User_ControllerTest {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));
    
    private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;
   
    private RestTemplate restTemplate;
    
    private MockRestServiceServer mockServer;
    
    private User user;
   
    private HttpStatus statusCode;
    
    private DBWrapper dbWrapper;
    
    @Autowired
    private UserRepository userRepository;
    
    public String getTestStatusMessage(){
        String result;
        try{
            String httpResult = this.restTemplate.getForObject("htttp://localhost:8094", String.class);
            result ="message Success result: " + httpResult;
        }catch(HttpStatusCodeException e){
            result = "Get failed with HttpStatusCode: " + e.getStatusCode() + "|" + e.getStatusText();
        }catch(RuntimeException re){
            result = "Get Failed>>> StackTrace: " +ExceptionUtils.getFullStackTrace(re);
        }
        return result;
    }
    
    @Before
    public void setUp() throws Exception {
        this.restTemplate = new RestTemplate();
        this.mockServer = MockRestServiceServer.createServer(restTemplate);
        
        this.dbWrapper = new DBWrapper();
        
    }
    
    @Test
    public void test_get_user_Controller() throws Exception {
        //This method checks getUser url.

        int userID = 1;
       
        this.mockServer.expect(requestTo("/get_User?userID=1"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess("{\"userID\":1,\"userName\":\"test1_username\",\"email\":\"test4@email.com\",\"pictureID\":1}"
                        ,MediaType.APPLICATION_JSON));

        ResponseEntity<User> result = restTemplate.getForEntity("/get_User?userID=1",User.class,userID);
        user = result.getBody();
        
        contentType = result.getHeaders().getContentType();
        statusCode = result.getStatusCode();
        this.mockServer.verify();
        System.out.println("Testing Microservice_User_controller http status ======> "+statusCode + " | "+contentType);
        Assert.assertEquals(userID, user.getUserID());
    }
    
    @Test
    public void test_create_user_Controller() throws Exception {
        
        String username = "Piggy";
        String email = "piggy@test.com";
        int pictureID = 1;
        String password = "ppppheee";
        
        User_CreateUser testUser  = new User_CreateUser();
        testUser.setUserName(username);
        testUser.setEmail(email);
        testUser.setPictureID(pictureID);
        testUser.setPassword(password);
        
        this.mockServer.expect(requestTo("/create_User"))
                .andExpect(method(HttpMethod.POST))
                .andExpect(content().contentType(contentType))     
                .andRespond(withStatus(HttpStatus.OK));
        
        ResponseEntity<User> result;
        result = restTemplate.postForEntity("/create_User",testUser, User.class);
        
        System.out.println("test_create_user_C result ====> "+result);
        this.mockServer.verify();
//        Assert.assertTrue(true);
    }
    
    @Test
    public void testGetAUser(){
        
        int userID = 1;
        String username = "test1_username";
        User tsUser = this.userRepository.findOne(userID);
        Assert.assertNotNull("fail testing - expected not null", tsUser);
        Assert.assertThat(username, is(tsUser.getUserName()));
    }
    
    @Test
    public void testCreateUser(){
       
        String username = "jacob";
        String email = "jacob@test.com";
        int pictureID = 1;
        String password = "12345678";
        
        User_CreateUser testUser  = new User_CreateUser();
        testUser.setUserName(username);
        testUser.setEmail(email);
        testUser.setPictureID(pictureID);
        testUser.setPassword(password);
  
        User inputUser = this.dbWrapper.createUser(testUser);
        Assert.assertNotNull("Failed, expedted not null ==> "+ inputUser);
        Assert.assertThat(username, is(inputUser.getUserName()));
        
    }
	
}
