/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.ArrayList;

/**
 *
 * @author znake
 */
public class Event {
    private int eventID;
    private int userID;
    private String userName;
    private String title;
    private String description;
    private String date;
    private String location;
    private String picturePath;
    private int catagoryID;
    private ArrayList<Integer> subCatagoryIDs;
    private ArrayList<Message> Messages;

    public Event(int eventID, int userID, String userName, String title, String description, String date, String location, String picturePath, int catagoryID, ArrayList<Integer> subCatagoryIDs, ArrayList<Message> Messages) {
        this.eventID = eventID;
        this.userID = userID;
        this.userName = userName;
        this.title = title;
        this.description = description;
        this.date = date;
        this.location = location;
        this.picturePath = picturePath;
        this.catagoryID = catagoryID;
        this.subCatagoryIDs = subCatagoryIDs;
        this.Messages = Messages;
    }

    public Event() {
    }

    
    
    
    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    

}

