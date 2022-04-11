/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.humber.models;

import java.util.Date;

/**
 *
 * @author Chaitanya
 */
public class BookingClass {
    private int id;
    private String location;
    private Date scheduledDate;
    private int userID;
    private int class_id;
    private String class_name;

    public BookingClass() {
    }

    public BookingClass(int id, String location, Date scheduledDate, int userID, int class_id, String className) {
        this.id = id;
        this.location = location;
        this.scheduledDate = scheduledDate;
        this.userID = userID;
        this.class_id = class_id;
        this.class_name = className;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(Date scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }  
}
