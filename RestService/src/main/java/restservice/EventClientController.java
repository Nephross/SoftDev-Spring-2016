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
}
