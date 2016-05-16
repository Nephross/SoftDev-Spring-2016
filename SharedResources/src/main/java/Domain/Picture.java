/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


/**
 *
 * @author Nephross
 */

@Entity
@Table(name = "Picture")
public class Picture implements Serializable {

//    @ManyToOne
//    private User user;
    
    @Id @GeneratedValue
    @Column(name = "pictureID")
    private int pictureID;
    
    @Column(name = "file_location")
    private String fileLocation;
    
    @OneToOne
    @PrimaryKeyJoinColumn
    private Category category;

    public Picture() {
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    
    public void setfileLocation(String inputPath) {
        this.fileLocation = inputPath;
    }
    
    public int getPictureID() {
        return this.pictureID;
    }
    
    public String getFileLocaiton() {
        return this.fileLocation;
    }
}
