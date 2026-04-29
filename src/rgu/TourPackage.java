/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rgu;

/**
 * Creates that Abstract TourPackage Class- both the SightSeeing Tour and the
 * CityTour - extends this class
 *
 * @author astel-15/12/2020
 */
public abstract class TourPackage {

    String description;
    String location;
    double tourCost;

    public TourPackage(String description, String location, double tourCost) {
        this.description = description;
        this.location = location;
        this.tourCost = tourCost;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public double getTourCost() {
        return tourCost;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTourCost(double tourCost) {
        this.tourCost = tourCost;
    }
    

    public void updateTourCost(double newCost) {
        if (newCost > tourCost) {
            tourCost = newCost;
        }
    }

    abstract public double getCost();

    @Override
    public String toString() {
        return "The chosen package is " + this.description + " It will be in " + this.location + " At the cost of " + this.tourCost;
    }
}
