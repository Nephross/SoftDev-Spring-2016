/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author znake
 */
public class Message {
    
    private String messageID;
    private String messageContent;
    private String date;
    private String eventID;
    private String userID;

    public Message(String messageID, String messageContent, String date, String eventID, String userID) {
        this.messageID = messageID;
        this.messageContent = messageContent;
        this.date = date;
        this.eventID = eventID;
        this.userID = userID;
    }

    public Message() {
    }

        
    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
    
    
    
}
