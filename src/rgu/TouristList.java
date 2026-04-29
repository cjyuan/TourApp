/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rgu;

import java.util.ArrayList;

/**Create Tourist ArrayList to which
 *individual tourists can be added
 * @author astel-14/12/2020
 */
public class TouristList {
   private ArrayList<String> TouristList;

    public TouristList() {
        this.TouristList = new ArrayList();
    }
    
   // public void getTourist(String name, String country , AudioLanguage la, double tourcost);

    public ArrayList<String> getTourist() {
        return TouristList;
    }  
}
