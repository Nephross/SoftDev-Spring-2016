/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restservice;

import Domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import restservice.clients.EventClient;

/**
 *
 * @author Ronni
 */
@RestController
public class EventClientController {
        
    @Autowired
    LoadBalancerClient loadBalancerClient;
        
    @Autowired
    EventClient eventClient;
    
        
    
    @RequestMapping(method = RequestMethod.GET, value = "/select_event", params = {"eventID"})
    public @ResponseBody Event selectEvent(@RequestParam(value = "eventID") int eventID) {
        return eventClient.getEvent(eventID);
    }
    
    @RequestMapping(value = "/create_event", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Event createEvent(@RequestBody Event event){
        return eventClient.createEvent(event);
    
    }
    
    //put method uses edit event object. @PathVariable("eventID") has to be same as a value in url
    @RequestMapping(value = "/update_event/{eventID}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Event updateEvent(@PathVariable("eventID") int id, @RequestBody Event inputEvent){
        
        //checking event id is same as id from getEvent
        //inputEvent doesnt have any eventID from client, because eventId is pathvariable id.
        //System findout which eventId should be updated.
        System.out.println("restservice.EventController.updateEvent() updateEvent id is =====> " + inputEvent.getEventID());
        
        //send to microserviceEvent
        return eventClient.updateEvent(id,inputEvent);
    }
}
