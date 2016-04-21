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
public class SubCatagory {
    
    private String subCatagoryID;
    private String name;

    public SubCatagory(String subCatagoryID, String name) {
        this.subCatagoryID = subCatagoryID;
        this.name = name;
    }

    public SubCatagory() {
    }

    
    
    public String getSubCatagoryID() {
        return subCatagoryID;
    }

    public void setSubCatagoryID(String subCatagoryID) {
        this.subCatagoryID = subCatagoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    
    
}
