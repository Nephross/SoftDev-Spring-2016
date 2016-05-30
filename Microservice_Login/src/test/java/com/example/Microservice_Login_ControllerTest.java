package com.example;

import Domain.Login_Attempt;
import Domain.Login_Response;
import Domain.User;
import Domain.User_CreateUser;
import java.nio.charset.Charset;
import microservice_Login.Microservice_Login_Application;
import microservice_Login_DBWrapper.DBWrapper;
import org.apache.commons.lang.exception.ExceptionUtils;
import static org.hamcrest.Matchers.is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
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
@SpringApplicationConfiguration(classes = Microservice_Login_Application.class)
public class Microservice_Login_ControllerTest {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
        MediaType.APPLICATION_JSON.getSubtype(),
        Charset.forName("utf8"));
    
    private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;
   
    private RestTemplate restTemplate;
    
    private MockRestServiceServer mockServer;
   
    private HttpStatus statusCode;
    
    private DBWrapper dbWrapper;
    
    
    public String getTestStatusMessage(){
        String result;
        try{
            String httpResult = this.restTemplate.getForObject("htttp://localhost:8093", String.class);
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
    public void test_login_Controller() throws Exception {
        
        String username = "77_username";
        String email = "77@email.com";
        int pictureID = 1;
        String password = "1234";
        
        Login_Attempt testLogin = new Login_Attempt();
        
        testLogin.setUserName(username);
        testLogin.setPassword(password);
        
        User_CreateUser testUser  = new User_CreateUser();
        testUser.setUserName(username);
        testUser.setEmail(email);
        testUser.setPictureID(pictureID);
        testUser.setPassword(password);
        
        this.mockServer.expect(requestTo("/attempt_Login"))
                .andExpect(method(HttpMethod.POST))
                .andExpect(content().contentType(contentType))
                .andRespond(withSuccess());
               // .andRespond(withStatus(HttpStatus.OK));
        
        ResponseEntity<Login_Response> result;
        result = restTemplate.postForEntity("/attempt_Login",testLogin, Login_Response.class);
        
        System.out.println("test_LoginAttampt_A result ====> "+result);
        this.mockServer.verify();
    }
    
    @Test
    public void test_login() throws Exception {
        
        String username = "77_username";
        String email = "77@email.com";
        int pictureID = 1;
        String password = "1234";
        
        Login_Attempt testLogin = new Login_Attempt();
        
        testLogin.setUserName(username);
        testLogin.setPassword(password);
        
        Login_Response loginResponse = this.dbWrapper.attemptLogin(testLogin);
        System.out.println("LoginResponse - UserName- : " + loginResponse.getUserName());
        System.out.println("LoginResponse - UserID- : " + loginResponse.getUserID());
        System.out.println("LoginResponse - email- : " + loginResponse.getEmail());
        System.out.println("LoginResponse - PictureID- : " + loginResponse.getPictureID());
        System.out.println("LoginResponse - LoggedIN- : " + loginResponse.getLoggedIn());
        
        Assert.assertNotNull("Failed, expedted not null ==> "+ loginResponse);
        Assert.assertThat(username, is(loginResponse.getUserName()));
    }

}

    