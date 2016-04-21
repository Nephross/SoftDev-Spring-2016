/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microserviceEvent;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.PostConstruct;
import microserviceEvent.domain.Event;
import microserviceEvent.domain.ConTestResponse;
import microserviceEvent.DBWrapper.DBWrapper;
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
public class RestCalls {
    
    
    private ConTestResponse testResponse;
    private DBWrapper DbWrapper;
    
    @PostConstruct
    public void init(){
        //Response object that will be wrapped in a json
        testResponse = new ConTestResponse();
        //DBWrapper handles the connection to DB with connection and thread pool.
        DbWrapper = new DBWrapper();
    }
    
    
}
