/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restservice.clients;

import Domain.User;
import Domain.User_CreateUser;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
/**
 *
 * @author peter
 */
//Define client rest service. microserviceUser has @EnableFeignClients 
@FeignClient("microserviceUser")
public interface UserClient {
    
    //specify endpoint and Http method
    @RequestMapping(method = RequestMethod.GET, value = "/get_User", params = {"userID"})
    User getUser(@RequestParam(value = "userID") int userID);
    
    @RequestMapping(method = RequestMethod.POST, value = "/create_User", consumes = MediaType.APPLICATION_JSON_VALUE)
    User createUser(@RequestBody User_CreateUser inputUser);
    
    @RequestMapping(value = "/update_User/{userID}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    User updateUser(@PathVariable("userID")int id,@RequestBody User inputUser);
}

