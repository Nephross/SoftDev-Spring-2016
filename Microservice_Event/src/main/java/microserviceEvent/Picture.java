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
@Table(name = "Picture")
public class Picture implements Serializable {
    
    @Id @GeneratedValue
    @Column(name = "pictureID")
    private int pictureID;
    
    @Column(name = "file_location")
    private String fileLocation;
    
        
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
