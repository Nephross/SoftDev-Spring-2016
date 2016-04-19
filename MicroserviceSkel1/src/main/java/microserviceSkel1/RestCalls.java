/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microserviceSkel1;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.PostConstruct;
import microserviceSkel1.domain.Event;
import microserviceSkel1.domain.MoreStuff;
import microserviceSkel1.domain.Stuff;
import microserviceSkel1.domain.ConTestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Ronni
 */
@Controller
public class RestCalls {
    
    private Stuff stuff;
    private ConTestResponse testResponse;
    
    @PostConstruct
    public void init(){
        
        Set<MoreStuff> moreStuff = new HashSet<>();
        moreStuff.add(new MoreStuff("Bob"));
        moreStuff.add(new MoreStuff("Rob"));
        stuff = new Stuff("test", moreStuff);
    }
    
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public ResponseEntity<Stuff> hiThere(){
        return new ResponseEntity<>(stuff, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/testdbcon", method = RequestMethod.GET)
    public ResponseEntity<ConTestResponse> testDbConnnection(){
        
        
        int outputInt = 0;
        ResponseEntity<ConTestResponse> testconResult = new ResponseEntity<ConTestResponse>(testResponse, HttpStatus.OK);
        return testconResult;
    }
    
    @RequestMapping(value = "/get_event", method = RequestMethod.GET)
    public ResponseEntity<Event> getEvent(){
        Event event = new Event("party", "Lots of partying", "IKEA", "now");
        return new ResponseEntity<>(event, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/update_event", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Event> updateEvent(@RequestBody Event event){
        System.out.println(event);
        if(event != null){
            event.setName(event.getName() + "1");
        }
        return new ResponseEntity<>(event, HttpStatus.OK);
    }
}
