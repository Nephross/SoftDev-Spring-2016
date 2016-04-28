/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.service;

import Domain.Event;
import com.example.AbstractTest;

import junit.framework.TestCase;
import static junit.framework.TestCase.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import restservice.clients.EventClient;

/**
 *
 * @author Hisayo
 */
@Transactional
public class RestService extends AbstractTest{
    
    @Autowired
    private EventClient eventClient;
    private Event event;
   
    @Before
    //run Eureka server first.
    //instance of the microservice event
    
    @Test
    public void testFindEvent() {
        int eventId = 1;
        eventClient.getEvent(eventId);
        
        assertNotNull("failure - expected not null", logger);
        TestCase.assertEquals("Event item : ","expected = Film 1", "actual = " + event.getTitle());
    }
    
    
    
}
