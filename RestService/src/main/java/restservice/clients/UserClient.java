/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restservice.clients;

import Domain.User;
import microservice_User_Domain.User_CreateUser;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
/**
 *
 * @author peter
 */
@FeignClient("microserviceUser")
public interface UserClient {
    
    @RequestMapping(method = RequestMethod.GET, value = "/getUser", params = {"userID"})
    User getUser(@RequestParam(value = "userID") int eventID);
    
    @RequestMapping(method = RequestMethod.POST, value = "/createUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    User createUser(@RequestParam(value = "inputUser") User_CreateUser inputUser);
}

