/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restservice;


import Domain.User;
import microserviceSkel1.domain.Event;
import Domain.Login_Attempt;
import Domain.Login_Response;
import Domain.User_CreateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import restservice.clients.LoginClient;
import restservice.clients.UserClient;
/**
 *
 * @author Nephross
 */
@RestController
public class UserController {
    @Autowired
    LoadBalancerClient loadBalancerClient;
        
    @Autowired
    UserClient userClient;
    
    @Autowired
    LoginClient loginClient;
    
    @Autowired
    RestserviceApplication.ConTestClient ConTestClient;
        
        
    @RequestMapping(method = RequestMethod.GET, value = "/get_User", params = {"userID"})
    public @ResponseBody User getUser(@RequestParam(value = "userID") int userID){
        
        return userClient.getUser(userID);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/Create_User",  consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody User createUser(@RequestParam(value = "inputUser") User_CreateUser inputUser){
        
        return userClient.createUser(inputUser);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/Login",  consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Login_Response attemptLogin(@RequestParam(value = "loginAttempt") Login_Attempt loginAttempt){
        
        return loginClient.attemptLogin(loginAttempt);
    }
    
    
}

        
    