/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microserviceSkel1.domain;

import java.util.Set;

/**
 *
 * @author Ronni
 */
public class Stuff {
    String from = "Skeleton1";
    String name;
    
    Set<MoreStuff> moreStuff;

    public Stuff() {
        super();
    }    
    
    public Stuff(String name, Set<MoreStuff> moreStuff) {
        this();
        this.name = name;
        this.moreStuff = moreStuff;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<MoreStuff> getMoreStuff() {
        return moreStuff;
    }

    public void setMoreStuff(Set<MoreStuff> moreStuff) {
        this.moreStuff = moreStuff;
    }
    
    
}
