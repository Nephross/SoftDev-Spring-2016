/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microservice_User;

import Domain.User;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.PostConstruct;
import microservice_User_DBWrapper.DBWrapper;
import microservice_User_Domain.User_CreateUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Ronni
 */
@Controller
public class Microservice_User_Controller {
    
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
    
    @RequestMapping(value = "/User/get_User", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@RequestBody int userID){
        User OutputUser = DbWrapper.getUser(userID);
        return new ResponseEntity<User>(OutputUser, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/User/Create_User", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateEvent(@RequestBody User_CreateUser inputUser){
        User OutputUser = null;
        if(inputUser != null){
            OutputUser = DbWrapper.createUser(inputUser);
        }
        if(OutputUser != null){
            return new ResponseEntity<User>(OutputUser, HttpStatus.OK);    
        }
        else{
            return null;
        }
        
    }
}
