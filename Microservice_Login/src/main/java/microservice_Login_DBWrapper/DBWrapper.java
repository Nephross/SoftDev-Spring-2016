/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microservice_Login_DBWrapper;


import Domain.User;
import ResourcesPools.Super_DBWrapper;
import Domain.Login_Attempt;
import Domain.Login_Response;
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
    
    public Login_Response attemptLogin(Login_Attempt login_attempt){
        Login_Response response = null;
        
        Session session = null;  
        Transaction tx = null;  

        try {  
            session = getSession();  
            tx = session.beginTransaction();  
            //some action  


            Query query = session.createSQLQuery("CALL attemptLogin(:inUsername, :pass)").addEntity(User.class)
                                                                              .setParameter("inUsername", login_attempt.getUserName())
                                                                              .setParameter("pass", login_attempt.getPassword());

            User output = null;    
            output = (User) query.uniqueResult();
            
            if(output != null){
                response = new Login_Response(output, true);
            }
            else{
                response = new Login_Response(null, false);
            }
            
            tx.commit();
            
        }
        catch (Exception ex) {  
            ex.printStackTrace();  
            tx.rollback();  
        }  
        finally {
            session.close();
        }  
        
        return response;
    }	
}
