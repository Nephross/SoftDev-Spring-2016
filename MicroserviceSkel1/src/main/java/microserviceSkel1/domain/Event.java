/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microserviceSkel1.domain;

import java.util.Date;

/**
 *
 * @author znake
 */
public class Event {
    private String name;
    private String description;
    private String location;
    private String timeOfEvent;

    public Event(String name, String description, String location, String timeOfEvent) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.timeOfEvent = timeOfEvent;
    }
    
    public Event() {
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTimeOfEvent() {
        return timeOfEvent;
    }

    public void setTimeOfEvent(String timeOfEvent) {
        this.timeOfEvent = timeOfEvent;
    }
    
}
