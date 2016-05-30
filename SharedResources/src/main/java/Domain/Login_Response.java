/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import Domain.User;

/**
 *
 * @author Nephross
 */
public class Login_Response {
     
    private int userID;
    private String userName;
    private String email;
    private int pictureID;
    private boolean loggedIn;
    
    
    public Login_Response(User inputUser, boolean inputBool){
        setUser(inputUser);
        setLoggedIn(inputBool);
    }
    
    public Login_Response(){
        
    }
    
    public void setUser(User inputUser) {
        this.userID = inputUser.getUserID();
        this.userName = inputUser.getUserName();
        this.email = inputUser.getEmail();
        this.pictureID = inputUser.getPictureID();
    }
    
    public void setLoggedIn(boolean inputBool) {
        this.loggedIn = inputBool;
    }
    
    
    
    public String getUserName(){
        return this.userName;
    }
    
    public int getUserID(){
        return this.userID;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public int getPictureID() {
        return this.pictureID;
    }
    
    public boolean getLoggedIn() {
        return this.loggedIn;
    }
}
