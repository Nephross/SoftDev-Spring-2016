/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Nephross
 */

@Entity
@Table(name = "Sub_Category")
public class Sub_Category implements Serializable{
    @Id @GeneratedValue
    @Column(name = "sub_categoryID")
    private int subCategoryID;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "default_picture_FK")
    private int defaultPictureID;
    
    @Column(name = "categoryID_FK")
    private int categoryID;
   
    public void setName(String inputName) {
        this.name = inputName;
    }
    
    public void setDefaultPicture(int inputId) {
        this.defaultPictureID = inputId;
    }
    
    public void setCategoryId(int inputId) {
        this.categoryID = inputId;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getDefaultPicture() {
        return this.defaultPictureID;
    }
    
    public int getCategoryId() {
        return this.categoryID;
    }
}
