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
    private User user;
    private boolean loggedIn;
    
    public void setUser(User inputUser) {
        this.user = inputUser;
    }
    
    public void setLoggedIn(boolean inputBool) {
        this.loggedIn = inputBool;
    }
    
    public Login_Response(User inputUser, boolean inputBool){
        this.user= inputUser;
        this.loggedIn = inputBool;
    }
}
