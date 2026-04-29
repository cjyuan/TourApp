/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rgu;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Comparator;

/**
 * abstract class encapsulating tourist details This provides the framework for
 * summarising information at the end of this application
 *
 * @author astel-14/12/2020
 */
public class Booking implements Comparable<Booking> {

    //every tourist has one tourist object and one tourpackage object
    private Tourist tourist;
    private TourPackage tourPackage;
    private Date datetime;

    public Booking(Tourist tourist, TourPackage tourPackage, Date datetime) {
        this.tourist = tourist;
        this.tourPackage = tourPackage;
        this.datetime = datetime;
    }

    public Tourist getTourist() {
        return tourist;
    }

    public TourPackage getTourPackage() {
        return this.tourPackage;
    }

    public Date getDatetime() {
        return this.datetime;
    }

    //public void addBooking(Booking bookings) {
       // bookings.addBooking(bookings);
    //}
    
   public static void sortByTourist(List<Booking> bookings) {
    bookings.sort(Comparator.comparing(b -> b.getTourist().getName()));
}
    
      @Override
    public int compareTo(Booking other) {
        return this.getDatetime().compareTo(other.getDatetime());
    }
    

    @Override
    public String toString() {
        return getTourist() + getDateAsString();
    }

    public String getDateAsString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return "The time is " + formatter.format(getDatetime());
    }

}
