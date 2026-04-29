/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rgu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author astel
 */
public class BookingUtil {

//create object level method
//then filter booking for each tourist    
    public double[] calculateBill(ArrayList<Booking> bookings, Tourist tourist) {
        ArrayList<Booking> touristBookings = new ArrayList<>();
        for (Booking b : bookings) {
            if (b.getTourist().equals(tourist)) {
                touristBookings.add(b);
            }
        }
        //Sort Bookings by datetime
        Collections.sort(touristBookings);
        
         //array of discount %
        double[] discounts = {0.0, 0.1,0.15,0.20,0.25,0.30,0.35, 0.40,0.45,0.5};
        
        //calculate total and discounted total
        double total = 0.0;
        double discountedTotal = 0.0;
        
        for (int i = 0; i < touristBookings.size(); i++){
            double cost = touristBookings.get(i).getTourPackage().getCost();
            total += cost;
            double discount = (i<10) ? discounts [i] : 0.5;
            discountedTotal += cost * (1-discount);      
        }
        
        return new double[]{total,discountedTotal};
    }
}

