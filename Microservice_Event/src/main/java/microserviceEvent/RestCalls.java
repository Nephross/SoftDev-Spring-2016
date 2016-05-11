/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microserviceEvent;

import Domain.Event;
import java.util.List;
import javax.annotation.PostConstruct;
import microserviceEvent.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityScan;
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
@EntityScan(basePackageClasses=Domain.Event.class) //Important since the entity is in dependcy and when hibernate scan
                                                    //this module.
public class RestCalls {
    
    
    @Autowired
    private EventRepository eventRepository;
    
    @PostConstruct
    public void init(){
        
    }
    
    
    @RequestMapping(value = "/create_event", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Event> createEvent(@RequestBody Event event){

        eventRepository.save(event);
        
        ResponseEntity<Event> selectEvent = new ResponseEntity<>(event, HttpStatus.OK);
        return selectEvent;
    }
    
    // call with http://localhost:8092/select_event?eventID=1
    @RequestMapping(value = "/select_event", method = RequestMethod.GET, params = {"eventID"})
    public @ResponseBody ResponseEntity<Event> selectEvent(@RequestParam(value = "eventID") int eventID){
        Event event = eventRepository.findOne(eventID);
        
        ResponseEntity<Event> selectEvent = new ResponseEntity<>(event, HttpStatus.OK);
        return selectEvent;
    }
    
    
    @RequestMapping(value = "/find_event", method = RequestMethod.GET, params = {"title"})
    public @ResponseBody ResponseEntity<List<Event>> selectEvent(@RequestParam(value = "title") String title){
        List<Event> events = eventRepository.findEventsByTitle(title);
        
        ResponseEntity<List<Event>> selectEvent = new ResponseEntity<>(events, HttpStatus.OK);
        return selectEvent;
    }
    
    @RequestMapping(value = "/update_event/{eventID}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Event> updateEvent(@PathVariable("eventID") int id, @RequestBody Event inputEvent){
       
        //urrentEvent find event id and the event objects. 
        Event currentEvent = eventRepository.findOne(id);
        System.out.println("currentEvent userID ====>" + currentEvent.getUserID());
        
        //set new event information in the current event objects.
        currentEvent.setTitle(inputEvent.getTitle());
        currentEvent.setDescription(inputEvent.getDescription());
        currentEvent.setDate(inputEvent.getDate());
        currentEvent.setLocation(inputEvent.getLocation());
        
        currentEvent.setCatagoryID(inputEvent.getCatagoryID());//FK category
        currentEvent.setPicturePath(inputEvent.getPicturePath());//FK picture
        
        //save to database
        eventRepository.save(currentEvent);
        
        ResponseEntity<Event> selectEvent = new ResponseEntity<>(currentEvent, HttpStatus.OK);
        return selectEvent;
    }
    
    
    
    public void updateMessage(Event currentEvent){ 
        //if there is new message, so addMessage in the list
       
    }
    
    public void updatePicture(Event currentEvent){
        //if picturePath is not same as existing pictureId, then make new picture and add in the event.
       
    }
}
