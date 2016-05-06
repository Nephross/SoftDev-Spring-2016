/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microservice_User;

import Domain.User;
import javax.annotation.PostConstruct;
import microservice_User_DBWrapper.DBWrapper;
import microservice_User.Repository.UserRepository;
import Domain.User_CreateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Ronni
 */
@Controller
@EntityScan(basePackageClasses = Domain.User.class)
public class Microservice_User_Controller {
    
    private DBWrapper DbWrapper;
    
    @Autowired
    private UserRepository userRepository;
    
    @PostConstruct
    public void init(){
        
        DbWrapper = new DBWrapper();
    }
    
    
    @RequestMapping(value = "/get_User", method = RequestMethod.GET, params = {"userID"})
    public @ResponseBody ResponseEntity<User> getUser(@RequestParam(value = "userID")@RequestBody int userID){
        User OutputUser = userRepository.findOne(userID);
        return new ResponseEntity<User>(OutputUser, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/create_User", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser(@RequestBody User_CreateUser inputUser){
        User OutputUser = null;
        if(inputUser != null){
            OutputUser = DbWrapper.createUser(inputUser);
        }
        if(OutputUser != null){
            return new ResponseEntity<>(OutputUser, HttpStatus.OK);    
        }
        else{
            return null;
        }
        
    }
    
    //Edit user
    @RequestMapping(value = "/update_User/{userID}", method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateUser(@PathVariable("userID") int id, @RequestBody User inputUser){
       //cheking inputUser has input objects.
        System.out.println("user updating id is====> " + inputUser.getUserID());
        
        //now currentUser find user id and the user objects. 
        User currentUser = userRepository.getOne(id);
        System.out.println("inputUser id + user name ====>" + currentUser.getUserID());
        
        //set new user information in the current user objects.
        currentUser.setUserName(inputUser.getUserName());
        currentUser.setEmail(inputUser.getEmail());
        currentUser.setPictureID(inputUser.getPictureID());
        
        System.out.println("currentUser email ====> "+ currentUser.getEmail());
        
        //save to database
        userRepository.save(currentUser);
        
        ResponseEntity<User> selectUser = new ResponseEntity<>(currentUser, HttpStatus.OK);
        return selectUser;
    }
}
