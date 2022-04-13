/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.humber.database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Chaitanya
 */
public class DBConnection {
    
    private Connection conn;

    public DBConnection() {
        this.initiateDBConnection();
    }
    
    private void initiateDBConnection() {
        try {
            if (conn != null) {
                return;
            }
            String dbURL = "jdbc:mysql://localhost:3333/crunch?autoReconnect=true&useSSL=FALSE";
            String userName = "root";
            String password = "1234";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
        } catch (Exception e) {
            System.out.println("**DB Connection Issue***" + e.toString());
        }
    }
    
     public Connection getConnection() {
        if(conn!= null) {
            initiateDBConnection();
        }
        return this.conn;
    }
    
    
}