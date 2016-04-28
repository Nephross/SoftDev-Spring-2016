/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microservice_User;

import Domain.User;
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
    
    
    @RequestMapping(value = "/get_User", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@RequestBody int userID){
        User OutputUser = DbWrapper.getUser(userID);
        return new ResponseEntity<User>(OutputUser, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/Create_User", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser(@RequestBody User_CreateUser inputUser){
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
