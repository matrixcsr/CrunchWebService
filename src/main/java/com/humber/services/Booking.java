/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.humber.services;

import com.humber.database.BookingsDao;
import com.humber.models.BookingClass;
import java.util.Date;
import java.util.List;
import javax.jws.WebService;

/**
 *
 * @author Chaitanya
 */
@WebService(endpointInterface = "com.humber.interfaces.IBooking")
public class Booking {

    public String createBooking(int userID, Date scheduledDay, String className, String location) {
        try {
            BookingsDao bookingsDao = BookingsDao.getBookingsDaoInstance();
            BookingClass booking = new BookingClass(-1, location, scheduledDay, userID, -1, className);
            int creationStatus = bookingsDao.createBooking(booking);
            if (creationStatus == 1) {
                return "success"; //User Created
            }
            return "failed";
        } catch (Exception e) {
            System.out.println("Register User Method Error");
        }
        return "failed";
    }
    
    public boolean deleteBooking(int userID, int bookingID) {
        BookingsDao bookingsDao = BookingsDao.getBookingsDaoInstance();
        return bookingsDao.deleteBooking(userID, bookingID);
    }
    
     public List<BookingClass> getUserBookings(int userID) {
        BookingsDao bookingsDao = BookingsDao.getBookingsDaoInstance();
        return bookingsDao.getUserBookings(userID);
    }

}
