/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.io.Serializable;
import java.sql.Date;
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
@Table(name = "Message")
public class Message implements Serializable{
    
    @Id @GeneratedValue
    @Column(name = "messageID")
    private int messageID;
    
    @Column(name = "message_content")
    private String messageContent;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    private Date date;
    
    @Column(name = "eventID_FK")
    private String eventID;
    
    @Column(name = "userID_FK")
    private String userID;

    public Message(String messageContent, Date date, String eventID, String userID) {
        this.messageContent = messageContent;
        this.date = date;
        this.eventID = eventID;
        this.userID = userID;
    }

    public Message() {
    }

        
    public int getMessageID() {
        return messageID;
    }

   
    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
