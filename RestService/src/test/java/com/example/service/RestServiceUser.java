/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.service;

import Domain.Event;
import Domain.User;
import com.example.AbstractTest;

import junit.framework.TestCase;
import static junit.framework.TestCase.assertNotNull;
import microservice_User.Repository.UserRepository;
import microservice_User_DBWrapper.DBWrapper;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import restservice.UserController;
import restservice.clients.EventClient;

/**
 *
 * @author Hisayo
 */
@Transactional
public class RestServiceUser extends AbstractTest{
    
    
    private DBWrapper userDB;
    
    
   
    @Test
    public void testFindOne() {
        
        int userID = 1;
        User user = userDB.getUser(userID);
        assertNotNull("failure - expected not null",user);
        TestCase.assertEquals("UserID : ",userID, user.getUserID());
    }
    
    
    
}
