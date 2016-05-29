/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restservice;


import Domain.User;
import Domain.Login_Attempt;
import Domain.Login_Response;
import Domain.User_CreateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
      
    //User interface. Autowired instances user objects from domain.user
    @Autowired
    UserClient userClient;
     
    @Autowired
    LoginClient loginClient;
        
        
    @RequestMapping(method = RequestMethod.GET, value = "/get_User", params = {"userID"})
    public @ResponseBody User getUser(@RequestParam(value = "userID") int userID){
        
        return userClient.getUser(userID);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/create_User",  consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody User createUser(@RequestBody User_CreateUser inputUser){
        
        return userClient.createUser(inputUser);
    }
    //put method uses edit user object. @PathVariable("userID") has to be same as a value in url
    @RequestMapping(value = "/update_User/{userID}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody User updateUser(@PathVariable("userID") int id, @RequestBody User inputUser){
        //checking user id is same as id from getUser
        System.out.println("restservice.UserController.updateUser() updateUser id is =====> " + inputUser.getUserID());
        //send to microserviceUser
        return userClient.updateUser(id,inputUser);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/login",  consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Login_Response attemptLogin(@RequestBody Login_Attempt loginAttempt){
        
        return loginClient.attemptLogin(loginAttempt);
    }
    
    
}

        
    