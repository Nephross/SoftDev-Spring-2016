/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microserviceSkel1.DBWrapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Future;

import javax.sql.DataSource;

import SharedResources.ResourcesPools.MySQLConnPool;
import SharedResources.ResourcesPools.SysThreadPool;

/**
 *
 * @author Nephross
 */
public class DBWrapper {
    
    private static DataSource connPool;
    private static SysThreadPool executor;
	
    private static Connection conn = null;
    private static CallableStatement stmt = null;
    private static ResultSet rset = null;
    private static String ZERO = "";
	
    public DBWrapper () {
    	System.out.println("Creating new DBWrapper");
    	MySQLConnPool connpool = new MySQLConnPool();
    	connPool = connpool.getconnPool();
    	executor = new SysThreadPool(10, 25);
    }
    public int mT_test_Connection(int inputInt) {
		if(inputInt < 0) {
			throw new IllegalArgumentException();
		}
		
		int outputInt = -1;
		Future<Integer> testFuture = executor.submit(new TestConCallable(inputInt, connPool));
		
		try {
			outputInt = testFuture.get(); 
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return outputInt;
	}
	
}
