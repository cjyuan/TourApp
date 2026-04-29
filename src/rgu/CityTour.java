/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rgu;

/**
 * CityTour extends from the Tourpackage parent class. It then integrates
 * getting whether a guide is chosen and the guide costs
 *
 * @author astel-14/12/2020
 */
public class CityTour extends TourPackage {

    public boolean withGuide;
    public double guideCost;

    public CityTour(String description, String location, double tourcost, boolean g, double m) {
        super(description, location, tourcost);
        withGuide = g;
        guideCost = m;
    }


    public double getGuideCost() {
        return this.guideCost;
    }

    public void updateGuideCost(double newCost) {
        if (newCost > guideCost) {
            guideCost = newCost;
        }
    }

    public boolean isWithGuide() {
        return this.withGuide;
    }


    @Override
    public double getCost() {
        if (withGuide) {
            return (guideCost + tourCost);
        } else {
            return tourCost;
        }
    }
    @Override
    public String toString() {
        return  super.toString() + "The visitor will be " + this.withGuide + "The guide cost wil be " + this.guideCost;
    }
    
}
