/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microserviceEvent;

import javax.annotation.PostConstruct;
import Domain.Event;
import microserviceEvent.DBWrapper.DBWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
        DbWrapper = new DBWrapper();
    }
    
    
    @RequestMapping(value = "/select_event", method = RequestMethod.GET, params = {"eventID"})
    public @ResponseBody ResponseEntity<Event> updateEvent(@RequestParam(value = "eventID") int eventID){
        Event event = DbWrapper.selectEvent(eventID);
        
        ResponseEntity<Event> testconResult = new ResponseEntity<>(event, HttpStatus.OK);
        return testconResult;
    }
    
}
