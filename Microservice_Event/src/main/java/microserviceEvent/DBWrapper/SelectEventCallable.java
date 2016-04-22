/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microserviceEvent.DBWrapper;

import ResourcesEvent.Event;
import ResourcesEvent.Message;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/**
 *
 * @author Ronni
 */
public class SelectEventCallable implements Callable<Event>{
    
    private static Connection conn = null;
    private static CallableStatement stmt = null;
    private static ResultSet rset = null;
    private int eventID;
    
    public SelectEventCallable(int inputData, Connection inputConn) {
        this.conn = inputConn;
        eventID = inputData;
    }

    @Override
    public Event call() throws Exception {
        try{
            Event event = new Event();
            
            stmt = conn.prepareCall("CALL `HobbyShareDB`.`select_event`(?)");
            stmt.setInt(1, eventID);
            try{
                rset = stmt.executeQuery();
                rset.next();
                
                event.setEventID(rset.getInt("eventID"));
                event.setTitle(rset.getString("title"));
                event.setDescription(rset.getString("description"));
                event.setDate(rset.getString("date"));
                event.setLocation(rset.getString("location"));
                event.setCatagoryID(rset.getInt("categoryID_FK"));
                event.setPicturePath(rset.getString("file_location")); // ToDo find picture path
                event.setUserID(rset.getInt("userID_FK"));
                event.setUserName(rset.getString("username"));
                //todo add subcatids and messages
                
                

            }
            catch (SQLException e){
                e.printStackTrace();
            }
            
            //gets the messages for the event
            stmt = conn.prepareCall("CALL `HobbyShareDB`.`get_messages_by_eventID`(?)");
            stmt.setInt(1, eventID);
            try{
                ArrayList<Message> messages = new ArrayList<Message>();
                
                rset = stmt.executeQuery();
                while(rset.next()){
                    Message message = new Message();
                    
                    message.setMessageID(rset.getString("messageID"));
                    message.setMessageContent(rset.getString("message_content"));
                    message.setEventID(rset.getString("eventID_FK"));
                    message.setUserID(rset.getString("userID_FK"));
                    message.setDate(rset.getString("date"));
                    messages.add(message);
                }
                
                event.setMessages(messages);
                   
            }
            catch (SQLException e){
                e.printStackTrace();
            }
            
            //gets the messages for the event
            stmt = conn.prepareCall("CALL `HobbyShareDB`.`get_subcat_by_eventID`(?)");
            stmt.setInt(1, eventID);
            try{
                ArrayList<Integer> subCategoryIDs = new ArrayList<Integer>();
                
                rset = stmt.executeQuery();
                while(rset.next()){
                    subCategoryIDs.add(rset.getInt("sub_categoryID"));
                }
                
                event.setSubCatagoryIDs(subCategoryIDs);
                   
            }
            catch (SQLException e){
                e.printStackTrace();
            }
            
            return event;
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Exception caught");
        }
        finally {
            try { if (rset != null) rset.close(); } catch(Exception e) { }
            try { if (stmt != null) stmt.close(); } catch(Exception e) { }
            try { if (conn != null) conn.close(); } catch(Exception e) { }
        }
        return new Event();
    }
    
}
