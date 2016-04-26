/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microservice_Login_Domain;

/**
 *
 * @author Nephross
 */
public class Login_Attempt {
    private String userName;
    private String password;
    
    public String getUserName(){
        return this.userName;
    }
    
    public String getPassword() {
        return this.password;
    }
}
