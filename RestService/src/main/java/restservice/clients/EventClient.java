/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restservice.clients;

import ResourcesEvent.Event;
import org.springframework.cloud.netflix.feign.FeignClient;
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
    
}
