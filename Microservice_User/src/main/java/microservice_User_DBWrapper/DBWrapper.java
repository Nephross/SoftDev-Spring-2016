/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microservice_User_DBWrapper;


import Domain.User;
import ResourcesPools.Super_DBWrapper;
import java.math.BigInteger;
import microservice_User_Domain.User_CreateUser;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import java.security.SecureRandom;


/**
 *
 * @author Nephross
 */
public class DBWrapper extends Super_DBWrapper {
    
    /** used for generating random salts */
    private SecureRandom random;
    
    public DBWrapper () {
        super();
    }
    
    public User createUser(User_CreateUser inputUser){
        User outputUser = null;
        
        Session session = null;  
        Transaction tx = null;  

        try {  
            session = getSession();  
            tx = session.beginTransaction();  
            //some action  

            String salt = getSalt();

            Query query = session.createSQLQuery("CALL createUser(:inUserName, :inEmail, :inPassword, :inSalt, :inPictureId)")
                                                                              .setParameter("inUserName", inputUser.getUserName())
                                                                              .setParameter("inEmail", inputUser.getEmail())
                                                                              .setParameter("inPassword", inputUser.getPassword())
                                                                              .setParameter("inSalt", salt)
                                                                              .setParameter("inPictureId", inputUser.getPictureID());

            query.executeUpdate();
            tx.commit();
            
            outputUser = new User(inputUser.getUserName(), inputUser.getEmail(),inputUser.getPictureID());
        }
        catch (Exception ex) {  
            ex.printStackTrace();  
            tx.rollback();  
        }  
        finally {
            session.close();
        }  
        
        return outputUser;
    }	
    
    
    //STUB!
    public User getUser(int inputId){
        return new User();
    }
    
    /**
    * Only initialize a SecureRandom object if it doesn't exist.
    * Private method, called upon user creation
    * 
    * Generates a 32 characters long (24 bytes) cryptographically secure salt 
    * returns it as a Base64 encoded String to ensure alphanumeric characters instead of bytes
    */
    private String getSalt(){
        try{
            if (random == null){
                    random = new SecureRandom();
            }
            byte salt[] = new byte[24];

            random.nextBytes(salt);
            // Encode the 24 bytes with base 64
            // Ensures we have a salt of alphanumeric characters
            return Base64.encode(salt);
        }
        catch (NullPointerException e){
            System.err.println("[ Couldn't generate salt ]\n[ Probably means DBWrapper isn't instantiated ]\nError: " + e.getMessage());
            e.printStackTrace();
            return "";
        }
        catch (Exception e){
            System.out.println("[ Couldn't generate salt ]\nError: " + e.getMessage());
            return "";
        }
    }
}
