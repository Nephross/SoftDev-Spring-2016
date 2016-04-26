/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Nephross
 */
@Entity
@Table(name = "User")
public class User implements Serializable{
    
    @Id @GeneratedValue
    @Column(name = "userID")
    private int userID;
    
    @Column(name = "username")
    private String userName;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "pictureID_FK")
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
    
    public void setPictureId(int inputId){
        this.pictureID = inputId;
    }
}
