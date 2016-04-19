/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microserviceSkel1.DBWrapper;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.Callable;
import javax.sql.DataSource;
/**
 *
 * @author Nephross
 */

public class TestConCallable implements Callable<Integer> {

    private static Connection conn = null;
    private static CallableStatement stmt = null;
    private static ResultSet rset = null;
    private DataSource connPool;
    private int inputInt;

    public TestConCallable(int inputData, DataSource connPool) {
        this.connPool = connPool;
        inputInt = inputData;
    }

    @Override
    public Integer call() throws Exception {
        try{
            conn = connPool.getConnection();
            stmt = conn.prepareCall("CALL `atletik`.`test_dbConnection`(?)");
            stmt.setInt(1, inputInt);
            try{
                rset = stmt.executeQuery();
                rset.next();
                return rset.getInt(1);

            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Exception caught");
        }
        finally {
            try { if (rset != null) rset.close(); } catch(Exception e) { }
            try { if (stmt != null) stmt.close(); } catch(Exception e) { }
            try { if (conn != null) conn.close(); } catch(Exception e) { }
        }
        return -1;
    }

}

