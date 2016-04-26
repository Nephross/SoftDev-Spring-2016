/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microserviceEvent;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
    @Column(name = "eventID")
    private int eventID;
    
    @Column(name = "userID_FK")
    private int userID;
    
    @Column(name = "title")
    private String title;
    
    @Column(name = "description")
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
    
    @ManyToMany
    @JoinTable(
                name="Event_Sub",
                joinColumns = @JoinColumn(name="eventID_FK", referencedColumnName = "eventID"),
                inverseJoinColumns = @JoinColumn(name="sub_categoryID_FK", referencedColumnName = "sub_categoryID")
                )
    private List<Sub_Category> subCatagories;
    
    @OneToMany(mappedBy="event")
    private List<Message> messages;


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

    public List<Sub_Category> getSubCatagories() {
        return subCatagories;
    }

    public void setSubCatagories(List<Sub_Category> subCatagories) {
        this.subCatagories = subCatagories;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> Messages) {
        this.messages = Messages;
    }

    public void addMessage(Message message){
            this.messages.add(message);
            if(message.getEvent() != this)
                message.setEvent(this);
            }
}

