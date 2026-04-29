/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rgu;


/**
 *
 * @author astel
 */
public class SightSeeingTour extends TourPackage {

    private double ticketCost;

    public SightSeeingTour(String description, String location, double tourCost, double t) {
        super(description, location, tourCost);
        ticketCost = t;
    }


    public double getTicketCost() {
        return this.ticketCost;
    }

    public void updateTicketCost(double newDouble) {
        if (newDouble > ticketCost){
        newDouble = ticketCost;
        }
    }

    
   @Override
    public double getCost() {
        return this.ticketCost + this.tourCost;
    }


   @Override 
    public String toString() {
  return  super.toString() + "ticketCost: "+ this.ticketCost;
    } 
}

