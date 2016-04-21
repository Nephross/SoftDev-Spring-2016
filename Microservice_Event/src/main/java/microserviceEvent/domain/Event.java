/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microserviceEvent.domain;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author znake
 */
public class Event {
    private String eventID;
    private String userID;
    private String title;
    private String description;
    private String date;
    private String location;
    private String picturePath;
    private Catagory catagory;
    private ArrayList<SubCatagory> subCatagories;
    private ArrayList<Message> Messages;

    public Event(String eventID, String userID, String title, String description, String date, String location, String picturePath, Catagory catagory, ArrayList<SubCatagory> subCatagories, ArrayList<Message> Messages) {
        this.eventID = eventID;
        this.userID = userID;
        this.title = title;
        this.description = description;
        this.date = date;
        this.location = location;
        this.picturePath = picturePath;
        this.catagory = catagory;
        this.subCatagories = subCatagories;
        this.Messages = Messages;
    }

    public Event() {
    }

    
    
    
    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public Catagory getCatagory() {
        return catagory;
    }

    public void setCatagory(Catagory catagory) {
        this.catagory = catagory;
    }

    public ArrayList<SubCatagory> getSubCatagories() {
        return subCatagories;
    }

    public void setSubCatagories(ArrayList<SubCatagory> subCatagories) {
        this.subCatagories = subCatagories;
    }

    public ArrayList<Message> getMessages() {
        return Messages;
    }

    public void setMessages(ArrayList<Message> Messages) {
        this.Messages = Messages;
    }

    

}
