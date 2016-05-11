/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restservice.clients;

import Domain.Event;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Ronni
 */
@FeignClient("eventmicroservice")
public interface EventClient {
        
    @RequestMapping(method = RequestMethod.GET, value = "/select_event", params = {"eventID"})
    Event getEvent(@RequestParam(value = "eventID") int eventID);
    
    @RequestMapping(value = "/create_event", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    Event createEvent(@RequestBody Event event);
    
    @RequestMapping(value = "/update_event/{eventID}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    Event updateEvent(@PathVariable("eventID")int id,@RequestBody Event inputEvent);
    
}
