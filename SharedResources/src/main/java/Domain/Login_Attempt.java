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
public class Login_Attempt {
    private String userName;
    private String password;
    
    
    public void setUserName(String input){
        this.userName = input;
    }
    
    public void setPassword(String input){
        this.password = input;
    }
    
    public String getUserName(){
        return this.userName;
    }
    
    public String getPassword() {
        return this.password;
    }
}
