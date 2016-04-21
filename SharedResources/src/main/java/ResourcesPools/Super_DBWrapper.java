/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResourcesPools;


import java.util.concurrent.Future;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


/**
 *
 * @author Nephross
 */
public class Super_DBWrapper {

   
    private static DataSource connPool;
    protected static SysThreadPool executor;
    private static MySQLConnPool connpool;

	
    //Setup of the DBWrapper with connection and threadpool
    public Super_DBWrapper () {
    	System.out.println("Creating new DBWrapper");
    	connpool = new MySQLConnPool();
    	connPool = connpool.getconnPool();
    	executor = new SysThreadPool(10, 25);
        connect();
    }
    
    public synchronized Connection getConnection(){
        try{
           return connPool.getConnection(); 
        }
        catch(SQLException se){
            return null;
        }
    }
    
    private synchronized void connect() {
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

