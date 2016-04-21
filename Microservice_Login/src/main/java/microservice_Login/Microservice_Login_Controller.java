/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microservice_Login;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.PostConstruct;
import microservice_Login_DBWrapper.DBWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import microservice_Login_Domain.Login_Attempt;
import microservice_Login_Domain.Login_Response;

/**
 *
 * @author Ronni
 */
@Controller
public class Microservice_Login_Controller {
    
    private DBWrapper DbWrapper;
    
    @PostConstruct
    public void init(){
        DbWrapper = new DBWrapper();
    }
   
    
    //Method called from the restservice.
    @RequestMapping(value = "/testdbcon", method = RequestMethod.GET)
    public ResponseEntity<ConTestResponse> testDbConnnection(){
        
        //DBWRapper returns the result from the db call, in this case an int, but can be any type.
        int outputInt = DbWrapper.test_Connection(1);
        //Wraps the return value in a reponsetype, and converts to JSON
        testResponse.setConnectionResponse(outputInt);
        ResponseEntity<ConTestResponse> testconResult = new ResponseEntity<ConTestResponse>(testResponse, HttpStatus.OK);
        return testconResult;
    }
    
    @RequestMapping(value = "/Login/Attempt_Login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Login_Response> attemptLogin(@RequestBody Login_Attempt login_Attempt){
        boolean loggedIn = DbWrapper.attemptLogin(login_Attempt);
        Login_Response login_Response = new Login_Response();
        return new ResponseEntity<Login_Response>(login_Response, HttpStatus.OK);
    }
    
    
}
