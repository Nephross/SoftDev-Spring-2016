/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microserviceEvent;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.PostConstruct;
import ResourcesEvent.Event;
import microserviceEvent.DBWrapper.DBWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
public class RestCalls {
    
    
    private DBWrapper DbWrapper;
    
    @PostConstruct
    public void init(){
        //DBWrapper handles the connection to DB with connection and thread pool.
        DbWrapper = new DBWrapper();
    }
    
    
    //Method called from the restservice.
    @RequestMapping(value = "/select_event", method = RequestMethod.GET, params = {"eventID"})
    public @ResponseBody ResponseEntity<Event> updateEvent(@RequestParam(value = "eventID") int eventID){
        //DBWRapper returns the result from the db call, in this case an int, but can be any type.
        Event event = DbWrapper.selectEvent(eventID);
        
        ResponseEntity<Event> testconResult = new ResponseEntity<Event>(event, HttpStatus.OK);
        return testconResult;
    }
    
}
