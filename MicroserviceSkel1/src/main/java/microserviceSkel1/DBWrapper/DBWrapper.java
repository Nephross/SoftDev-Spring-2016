/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microserviceSkel1.DBWrapper;

import ResourcesPools.MySQLConnPool;
import ResourcesPools.SysThreadPool;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.concurrent.Future;

import javax.sql.DataSource;

/**
 *
 * @author Nephross
 */
public class DBWrapper {
    
    private static DataSource connPool;
    private static SysThreadPool executor;
    private static MySQLConnPool connpool;
	
    private static Connection conn = null;
    private static CallableStatement stmt = null;
    private static ResultSet rset = null;
    private static String ZERO = "";
	
    //Setup of the DBWrapper with connection and threadpool
    public DBWrapper () {
    	System.out.println("Creating new DBWrapper");
    	connpool = new MySQLConnPool();
    	connPool = connpool.getconnPool();
    	executor = new SysThreadPool(10, 25);
        connect();
    }
    
    //Example method for using the connection and threadpool
    public int test_Connection(int inputInt) {
            if(inputInt < 0) {
                    throw new IllegalArgumentException();
            }

            int outputInt = -1;
            //This following line is the one where we send in the callable object we created into the threadpool executor to cue and
            //then get the return value in the form of a Future<T>. 
            Future<Integer> testFuture = executor.submit(new TestConCallable(inputInt, connPool));

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
    
    private void connect() {
            try {
                    // This will load the MySQL driver, each DB has its own driver
                    Class.forName("com.mysql.jdbc.Driver");//If this line throws an exception you haven't set up the jdbc driver correctly on your pc
                    // Setup the connection with the DB
            }
            catch(Exception e) {
                    System.out.println("Connection to SQL Database failed!");
                    e.printStackTrace();			
            }		
	}
	
}
