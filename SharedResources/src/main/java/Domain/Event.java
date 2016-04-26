/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author znake
 */

@Entity
@Table(name = "Event")
public class Event implements Serializable{
    
    @Id @GeneratedValue
    @Column(name = "userID")
    private int eventID;
    
    @Column(name = "userID_FK")
    private int userID;
    
    @Column(name = "title")
    private String title;
    
    @Column(name = "descreption")
    private String description;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    private Date date;
    
    @Column(name = "location")
    private String location;
    
    @Column(name = "pictureID_FK")
    private int pictureID;
    
    @Column(name = "categoryID_FK")
    private int catagoryID;
    
    private ArrayList<Integer> subCatagoryIDs;
    private ArrayList<Message> Messages;

    public Event(int userID, String title, String description, Date date, String location, int pictureID, int catagoryID, ArrayList<Integer> subCatagoryIDs, ArrayList<Message> Messages) {
        this.userID = userID;
        this.title = title;
        this.description = description;
        this.date = date;
        this.location = location;
        this.pictureID = pictureID;
        this.catagoryID = catagoryID;
        this.subCatagoryIDs = subCatagoryIDs;
        this.Messages = Messages;
    }

    public Event() {
    }

    
    
    public int getEventID() {
        return eventID;
    }

    

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPicturePath() {
        return pictureID;
    }

    public void setPicturePath(int pictureID) {
        this.pictureID = pictureID;
    }

    public int getCatagoryID() {
        return catagoryID;
    }

    public void setCatagoryID(int catagoryID) {
        this.catagoryID = catagoryID;
    }

    public ArrayList<Integer> getSubCatagoryIDs() {
        return subCatagoryIDs;
    }

    public void setSubCatagoryIDs(ArrayList<Integer> subCatagoryIDs) {
        this.subCatagoryIDs = subCatagoryIDs;
    }

    public ArrayList<Message> getMessages() {
        return Messages;
    }

    public void setMessages(ArrayList<Message> Messages) {
        this.Messages = Messages;
    }


}

