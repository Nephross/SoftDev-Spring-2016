/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microserviceSkel1.DBWrapper;

import ResourcesPools.Super_DBWrapper;
import java.math.BigInteger;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Nephross
 */
public class DBWrapper extends Super_DBWrapper {
    
    public DBWrapper () {
        super();
    }
    
    public int test_Connection(int inputInt){
        int outputInt = -1;
        
            Session session = null;  
            Transaction tx = null;  

            try {  
                session = getSession();  
                tx = session.beginTransaction();  
                //some action  

                Query query = session.createSQLQuery("CALL test_dbConnection(:inputInt)").setParameter("inputInt", inputInt);
		
                //Query can return list if you expect more than one result. This example does not, and we are thus using another method
                //List result = query.list();
                
                BigInteger result = (BigInteger) query.uniqueResult();
                outputInt = result.intValue();
                
                
                tx.commit();
            }catch (Exception ex) {  
                ex.printStackTrace();  
                tx.rollback();  
            }  
            finally {session.close();}  
        
        return outputInt;
    }
}
