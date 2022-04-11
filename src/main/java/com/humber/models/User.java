/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.humber.models;

/**
 *
 * @author Chaitanya
 */
public class User {
    /*ID is used only while retrieving users*/
    int id;
    String name;
    String email;
    boolean isAdmin;
    byte[] hash;
    int membership_id;
    
    public User() {
    }

    public User(int id, String name, String email, boolean isAdmin, byte[] hash, int membership_id) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.isAdmin = isAdmin;
        this.hash = hash;
        this.membership_id = membership_id;
    }

    public int getMembership_id() {
        return membership_id;
    }

    public void setMembership_id(int membership_id) {
        this.membership_id = membership_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public byte[] getHash() {
        return hash;
    }

    public void setHash(byte[] hash) {
        this.hash = hash;
    }
    
    
}
