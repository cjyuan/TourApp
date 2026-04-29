/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rgu;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author astel
 */
public class TourAgent implements Comparable<TourAgent> {
//This defines the TourAgent Object

    private String name;
    private String location;
//This is the public contructor; what data
//is acuited and the set to string in line
//26 

    public TourAgent(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    

    @Override
    public String toString() {
        return "Agent " + name + "is based in " + location;
    }

    @Override
    public int compareTo(TourAgent other) {
        return this.name.compareTo(other.getName());
    }
}


