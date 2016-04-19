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
	
    public DBWrapper () {
    	System.out.println("Creating new DBWrapper");
    	connpool = new MySQLConnPool();
    	connPool = connpool.getconnPool();
    	executor = new SysThreadPool(10, 25);
        connect();
    }
    public int test_Connection(int inputInt) {
            if(inputInt < 0) {
                    throw new IllegalArgumentException();
            }

            int outputInt = -1;
            connpool.loadDriver();
            Future<Integer> testFuture = executor.submit(new TestConCallable(inputInt, connPool));

            try {
                    outputInt = testFuture.get(); 
            }
            catch(Exception e){
                    e.printStackTrace();
            }
            return outputInt;
	}
    
    private void connect() {
            try {
                    // This will load the MySQL driver, each DB has its own driver
                    Class.forName("com.mysql.jdbc.Driver");//If this line throws an exception you haven't set up the jdbc driver correctly on your pc
                    // Setup the connection with the DB

                    //connection = DriverManager.getConnection("jdbc:mysql://91.100.101.181:3306/atletik?user=AtletikXP&password=AtletikXP.13A"); //Change password and database name
                    //connection = DriverManager.getConnection("jdbc:mysql://db4free.net/flugz?user=prask&password="+ password + ""); //Change password and database name

            }
            catch(Exception e) {
                    System.out.println("Connection to SQL Database failed!");
                    e.printStackTrace();			
            }		
	}
	
}
