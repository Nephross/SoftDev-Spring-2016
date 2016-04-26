/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microserviceEvent;

import Domain.Event;
import javax.annotation.PostConstruct;
import microserviceEvent.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityScan;
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
@EntityScan(basePackageClasses=Domain.Event.class)
public class RestCalls {
    
    
    @Autowired
    private EventRepository eventRepository;
    
    @PostConstruct
    public void init(){
        
    }
    
    // call with http://localhost:8092/select_event?eventID=1
    @RequestMapping(value = "/select_event", method = RequestMethod.GET, params = {"eventID"})
    public @ResponseBody ResponseEntity<Event> selectEvent(@RequestParam(value = "eventID") int eventID){
        Event event = eventRepository.findOne(eventID);
        
        ResponseEntity<Event> selectEvent = new ResponseEntity<>(event, HttpStatus.OK);
        return selectEvent;
    }
    
}
