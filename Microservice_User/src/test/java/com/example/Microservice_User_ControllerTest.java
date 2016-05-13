package com.example;

import Domain.User;
import microservice_User.Microservice_User_Controller;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import javax.ws.rs.HttpMethod;
import microservice_User.Microservice_User_Application;
import microservice_User.Repository.UserRepository;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import org.junit.Assert;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.test.web.client.MockRestServiceServer;

import org.springframework.test.web.client.match.MockRestRequestMatchers; 
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import org.springframework.web.client.RestTemplate;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Microservice_User_Application.class)
public class Microservice_User_ControllerTest {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));
    
    private HttpMessageConverter mappingJackson2HttpMessageConverter;
   
    private RestTemplate restTemplate;
    
    private MockRestServiceServer mockServer;
    
    private User user;
   
    private HttpStatus statusCode;
    
    @Autowired
    private UserRepository userRepository;
    
    
    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters){
        //Jeg har ikke brugt den...
        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters)
                .stream().filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
                .findAny().get();
        
        Assert.assertNotNull("The JSON message converter must not be null", 
                this.mappingJackson2HttpMessageConverter);
        
    }
    
    @Before
    public void setUp() throws Exception {
        this.restTemplate = new RestTemplate();
        this.mockServer = MockRestServiceServer.createServer(restTemplate);
        
    }
    
    @Test
    public void test_get_user_Controller() throws Exception {
        
// Der er ikke helt klar.. jeg skal ændre withStatus i sted for withSuccess.
        this.mockServer.expect(requestTo("/get_User?userID=1"))
                .andExpect(MockRestRequestMatchers.method(org.springframework.http.HttpMethod.GET))
                .andRespond(withSuccess("{ \"userID\":\"1\" ,\"username\":\"_username\",\"email\":\"test4@email.com\",\"pictureID_FK\":\"1\"}"
        ,MediaType.APPLICATION_JSON));

        ResponseEntity<User> result = restTemplate.getForEntity("/get_User?userID=1",User.class,userRepository.getOne(1));
        user = result.getBody();
        
        contentType = result.getHeaders().getContentType();
        statusCode = result.getStatusCode();
        this.mockServer.verify();
     
        
    }
    
    @Test
    public void testGetAUser(){
        
        int userID = 1;
        String username = "username";
        User tsUser = this.userRepository.findOne(userID);
        Assert.assertNotNull("fail testing - expected not null", tsUser);
        Assert.assertThat(username, is(tsUser.getUserName()));
    }
	
}
