/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microserviceEvent.DBWrapper;


import Domain.Event;
import ResourcesPools.Super_DBWrapper;
import java.util.concurrent.Future;


/**
 *
 * @author Nephross
 */
public class DBWrapper extends Super_DBWrapper {
    	
    public DBWrapper () {
    	super();
    }
    
    //Example method for using the connection and threadpool
    public Event selectEvent(int eventID) {
            if(eventID < 0) {
                    throw new IllegalArgumentException();
            }

            Event event = null;
            //This following line is the one where we send in the callable object we created into the threadpool executor to cue and
            //then get the return value in the form of a Future<T>. 
            Future<Event> testFuture = executor.submit(new SelectEventCallable(eventID, getConnection()));

            try {
                //recovering the contained int from the future.
                    event = testFuture.get(); 
            }
            catch(Exception e){
                    e.printStackTrace();
            }
            //And returning the value.
            return event;
	}	
}
