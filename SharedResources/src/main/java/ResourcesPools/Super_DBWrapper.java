/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResourcesPools;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Nephross
 */
public class Super_DBWrapper {
    private SessionFactory sessionFactory;

	
    //Setup of the DBWrapper with connection and threadpool
    public Super_DBWrapper () {
    	System.out.println("Creating new DBWrapper");
    	sessionFactory = HibernateSessionManager.getSessionFactory();
    }
    
    public synchronized Session getSession(){
        try{
           return sessionFactory.openSession(); 
        }
        catch(Exception se){
            return null;
        }
    }
    
}
