/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microserviceEvent.DBWrapper;


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
    public int test_Connection(int inputInt) {
            if(inputInt < 0) {
                    throw new IllegalArgumentException();
            }

            int outputInt = -1;
            //This following line is the one where we send in the callable object we created into the threadpool executor to cue and
            //then get the return value in the form of a Future<T>. 
            Future<Integer> testFuture = executor.submit(new TestConCallable(inputInt, getConnection()));

            try {
                //recovering the contained int from the future.
                    outputInt = testFuture.get(); 
            }
            catch(Exception e){
                    e.printStackTrace();
            }
            //And returning the value.
            return outputInt;
	}	
}
