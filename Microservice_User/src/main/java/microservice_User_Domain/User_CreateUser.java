/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microservice_User_Domain;

/**
 *
 * @author Nephross
 */
public class User_CreateUser {
    
    private String userName;
    private String email;
    private int pictureID;
    private String password;
    
    public String getUserName(){
        return this.userName;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public int getPictureID(){
        return this.pictureID;
                
    }
    
    public String getPassword() {
        return this.password;
    }
    
    
}
