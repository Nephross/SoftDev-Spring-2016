/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microserviceEvent;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Nephross
 */

@Table(name = "Event_Sub")
public class Event_Sub implements Serializable{
    
    @Column(name = "eventID_FK")
    private int eventID_FK;
    
    @Column(name = "sub_categoryID_FK")
    private int sub_categoryID_FK;
}
