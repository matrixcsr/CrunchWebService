/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.humber.database;

import com.humber.models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chaitanya
 */
public class UsersDao {

    private static UsersDao instance;

    private Connection connection;

    public UsersDao() {
        DBConnection db = new DBConnection();
        connection = db.getConnection();
    }

    //SingleTon
    public static UsersDao getUsersDaoInstance() {
        if (instance == null) {
            return new UsersDao();
        }
        return instance;
    }

    public int createUserAccount(User user) {
        String sqlQuery = "INSERT INTO users(name,email,hash, salt) VALUES(?,?,?,?)";
        try {
            PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement(sqlQuery);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setBytes(3, user.getHash());
            pstmt.setString(4, "");/*Not Implementing Salt for now*/
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    public boolean isUserExists(String email) {
        boolean userExists = false;
        try {
            String sqlQuery = "SELECT email from users where email=?";
            PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement(sqlQuery);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.isBeforeFirst()) {
                userExists = true;
            }
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userExists;
    }

    public User getUserLoginDetails(String email) {
        User user = new User();
        try {
            String query = "SELECT * FROM users WHERE email=?";
            PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement(query);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setName(rs.getString("name"));
                user.setHash(rs.getBytes("hash"));
                user.setMembership_id(rs.getInt("membership_id"));
                user.setIsAdmin(rs.getBoolean("is_admin"));
            }
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> getAllUsers(int currentUserID) {
        PreparedStatement pstmt;
        List<User> users = new ArrayList<User>();
        try {
            String searchQuery = "SELECT * FROM users where id != ?";
            pstmt = (PreparedStatement) connection.prepareStatement(searchQuery);
            pstmt.setInt(1, currentUserID);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                users.add(user);
            }
            pstmt.close();
        } catch (SQLException e) {
            return new ArrayList<>(); //Empty Array
        }
        return users;
    }
}
