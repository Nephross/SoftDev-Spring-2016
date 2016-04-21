/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microserviceEvent.domain;

/**
 *
 * @author Peter
 */
public class ConTestResponse {
    private String From = "Skeleton1";
    private int connectionResponse = 0;
    
    public ConTestResponse(int inputInt){
        this.connectionResponse = inputInt;
    }
    
    public ConTestResponse(){
        
    }
    
    public void setConnectionResponse(int inputInt){
        connectionResponse = inputInt;
    }
    
    public int getConnectionResponse(){
        return this.connectionResponse;
    }
}
