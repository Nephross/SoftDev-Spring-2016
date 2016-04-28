/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restservice.clients;


import Domain.User;
import microservice_Login_Domain.Login_Attempt;
import microservice_Login_Domain.Login_Response;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author peter
 */
@FeignClient("microserviceLogin")
public interface LoginClient {
    
    @RequestMapping(method = RequestMethod.POST, value = "/attemptLogin", consumes = MediaType.APPLICATION_JSON_VALUE)
    Login_Response attemptLogin(@RequestParam(value = "loginAttempt") Login_Attempt loginAttempt);
}




