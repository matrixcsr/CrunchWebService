/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.humber.interfaces;

import com.humber.models.BookingClass;
import java.util.Date;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author Chaitanya
 */
@WebService
public interface IBooking {
    @WebMethod(operationName = "createBooking")
    public String createBooking(int userID, Date scheduledDay, String className, String location);
    
    @WebMethod(operationName = "getUserBookings")
    public List<BookingClass> getUserBookings(int userID);
    
    @WebMethod(operationName = "deleteBooking")
    public boolean deleteBooking(int userID, int bookingID);
}
