/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microservice_Login;

import javax.annotation.PostConstruct;
import microservice_Login_DBWrapper.DBWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import Domain.Login_Attempt;
import Domain.Login_Response;

/**
 *
 * @author Peter
 */
@Controller
public class Microservice_Login_Controller {
    
    private DBWrapper DbWrapper;
    
    @PostConstruct
    public void init(){
        DbWrapper = new DBWrapper();
    }
   
        
    @RequestMapping(value = "/attempt_Login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Login_Response> attemptLogin(@RequestBody Login_Attempt login_Attempt){
        System.out.println("Calling DBwrapper for login attempt");
        Login_Response login_Response = DbWrapper.attemptLogin(login_Attempt);
        
        System.out.println("Loginattempt executed");
        return new ResponseEntity<Login_Response>(login_Response, HttpStatus.OK);
    }
    
    
}
