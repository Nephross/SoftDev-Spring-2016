/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author Nephross
 */
public class User {
    
    private int userID;
    private String userName;
    private String email;
    private int pictureID;
    
    public int getUserID(){
        return this.userID;
    }
    
    public String getUserName(){
        return this.userName;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public int getPictureID(){
        return this.pictureID;
    }
    
    public void setUserName(String inputName){
        this.userName = inputName;
    }
    
    public void setEmail(String inputEmail){
        this.email = inputEmail;
    }
}
