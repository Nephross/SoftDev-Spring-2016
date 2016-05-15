/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import Domain.Event;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import microserviceEvent.MicroserviceEventApplication;
import microserviceEvent.Repository.EventRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.ConfigFileApplicationContextInitializer;

/**
 *
 * @author Ronni
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MicroserviceEventApplication.class, 
    initializers = ConfigFileApplicationContextInitializer.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
@DatabaseSetup("todo-entries.xml")

public class EventTest {
    
    @Autowired
    private EventRepository repository;
    
    @Test
    public void selectEventTest(){
        Event event = repository.findOne(1);
        assertThat(event.getUserID()).isEqualTo(2);
        
    }
}
