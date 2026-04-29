/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rgu;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

/**
 *
 * @author astel
 */
public class TourApp {

    public static  void main(String[] args) {
        //create tourpackage
        CityTour cityTour = new CityTour("A city Tour in York", "York", 10.5, false, 8.5);
        SightSeeingTour sightTour = new SightSeeingTour("A sightseeing tour in Carlisle", "Carlisle", 120.0, 0);
        
        ArrayList<TourPackage>tourPackages = new ArrayList<>();
        tourPackages.add(cityTour);
        tourPackages.add(sightTour);
        
        System.out.println("A tour package is added to TourApp: " + cityTour);
        System.out.println("A tour package is added to TourApp: " + sightTour);
         
        //create tourist and language
        Tourist adam = new Tourist("Adam", "Russia", AudioLanguage.ENGLISH);
        System.out.println("Tourist : " + adam.getName() + " has been added to the tour app");
        
        //create booking
        ArrayList<Booking>bookings = new ArrayList<>();
        bookings.add(new Booking(adam,sightTour, new Date()));
        bookings.add(new Booking(adam, cityTour, new Date(System.currentTimeMillis() - 86400000L)));
        System.out.println(adam.getName() + " booked" + sightTour);
        System.out.println("A custom tour package created for: " + adam.getName() + " without a tour guide");
        
        //calculate bill
        BookingUtil util = new BookingUtil();
        double bills[] = util.calculateBill(bookings,adam);
        System.out.println("The total bill for  " + adam.getName() + " £"  + bills[0]);
        System.out.println("The discounted bill for  " + adam.getName() + " £"  + bills[1]);
        
        //update tourcost base
        cityTour.updateTourCost(100);
        System.out.println("A custom tour package cost updated: " + cityTour);
         
         //recalculate bill
      
        double newbills[] = util.calculateBill(bookings,adam);
        System.out.println("The total bill for  " + adam.getName() + " £"  + newbills[0]);
        System.out.println("The discounted bill for  " + adam.getName() + " £"  + newbills[1]);
    }
}
        

        