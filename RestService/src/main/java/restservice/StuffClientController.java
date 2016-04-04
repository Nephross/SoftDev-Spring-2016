/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restservice;

import microserviceSkel1.domain.Event;
import microserviceSkel1.domain.Stuff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import restservice.RestserviceApplication.EventClient;
import restservice.RestserviceApplication.StuffClient;

/**
 *
 * @author Ronni
 */
@RestController
public class StuffClientController {
    
    @Autowired
    LoadBalancerClient loadBalancerClient;
    
    @Autowired
    StuffClient stuffClient;
    
    @Autowired
    EventClient eventClient;
    
    @RequestMapping("/get_stuff")
    @ResponseBody
    Stuff getStuff() {
        return stuffClient.getStuff();
    }
    
    @RequestMapping("/get_event")
    @ResponseBody
    Event getEvent() {
        return eventClient.getEvent();
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/update_event", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    Event updateEvent(@RequestBody Event event) {
        return eventClient.updateEvent(event);
    }
}
