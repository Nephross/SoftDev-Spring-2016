/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microserviceEvent;

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
@Table(name = "Category")
public class Category implements Serializable{
    
    @Id @GeneratedValue
    @Column(name = "categoryID")
    private int categoryID;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "default_picture_FK")
    private int defaultPictureID;
}
