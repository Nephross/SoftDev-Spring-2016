/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restservice;

import ResourcesEvent.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
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
    
    @Autowired
    RestserviceApplication.ConTestClient ConTestClient;
        
    
    @RequestMapping(method = RequestMethod.GET, value = "/select_event", params = {"eventID"})
    public @ResponseBody Event updateEvent(@RequestParam(value = "eventID") int eventID) {
        return eventClient.getEvent(eventID);
    }
}
