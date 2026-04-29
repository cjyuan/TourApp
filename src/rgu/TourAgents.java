/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rgu;

import java.util.*;

/**Creates the ArrayList to 
 *fill the Combo Box in TourAgent Interface
 * @author astel-14/12/2020
 */


public class TourAgents {
    public static void main(String[] args) {
        List<TourAgent> agents = new ArrayList<>(Arrays.asList(
            new TourAgent("Bill", "York"),
            new TourAgent("Andrew", "Carlile")
        ));

        Collections.sort(agents); // uses compareTo

        for (TourAgent agent : agents) {
            System.out.println(agent);
        }
    }
}
        //System.out.println("A tour package is added to TourApp: " + cityTour);
        //System.out.println("A tour package is added to TourApp: " + sightTour);
         
        //create tourist and language
       // Tourist adam = new Tourist("Adam", "Russia", AudioLanguage.ENGLISH);
        //System.out.println("Tourist : " + adam.getName() + " has been added to the tour app");
    
    //private ArrayList<String> TourAgent;

   // public TourAgents() {
        //this.TourAgent = new ArrayList();
    //}
    
    //public void update(name s1, Location l1){
       // TourAgent.addName(s1);
        //TourAgent.addLocation(l1);
        //this.TourAgent.add("TourAgent"+s1.getName()+" is located in "+l1.getLocation.toString());
    //}

   // public ArrayList<String> getTourAgent() {
    //    return TourAgent;
   // }
    
    
    
//}
   // TourAgent bill = new TourAgent("bill", "France");
   // TourAgent tim = new TourAgent("tim","Glasgow");
   
   
   //ArrayList <String> TourAgent = new ArrayList<>();
   //TourAgent.add (bill);
   //TourAgent.add (tim);
   
   //public ArrayList <TourAgents> getTourAgent() {
       // return TourAgent;
//}
   
   
   
//public void addTourAgent(){
    // TourAgent.add (Name,Location);
//}
//public void addTourAgent(){
     //return (name,lcation);
//}
//}
//public TourAgent A (String name, String location){
// this.name = Bill;
// this.location = Aberdeen;
//}

//public TourAgent B (String name, String location){
 //this.name = Sam;
 //this.location = Inverurie;
 //}

//@Override
// public String toString() {
// return "Agent " + name + "is based in " + location;
// }

//method to create two Touragent objects
//public static void main(String[] args) {
 
 
// dave.displayTouristDetails();
// jim.displayTouristDetails();
// } 
// }