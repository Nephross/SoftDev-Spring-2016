/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Nephross
 */

@Entity
@Table(name = "Category")
public class Category implements Serializable{
    
    @Id @GeneratedValue
    @Column(name = "categoryID")
    private int categoryID;
    
    @Column(name = "name")
    private String name;
    
    @OneToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "default_picture_FK")
    @JsonIgnore //Loopback block code.
    private Picture picture;

    public Category() {
    }
    
    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    
}
