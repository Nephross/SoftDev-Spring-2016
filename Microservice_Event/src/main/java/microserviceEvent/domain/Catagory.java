/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microserviceEvent.domain;

/**
 *
 * @author znake
 */
public class Catagory {
    
    private String catagoryID;
    private String name;

    public Catagory(String catagoryID, String name) {
        this.catagoryID = catagoryID;
        this.name = name;
    }

    public Catagory() {
    }

    
    
    public String getCatagoryID() {
        return catagoryID;
    }

    public void setCatagoryID(String catagoryID) {
        this.catagoryID = catagoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
    
}
