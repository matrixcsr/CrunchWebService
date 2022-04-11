/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.humber.services;

import com.humber.database.UsersDao;
import com.humber.models.User;
import com.humber.utils.Utils;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import javax.jws.WebService;

/**
 *
 * @author Chaitanya
 */
@WebService(endpointInterface = "com.humber.interfaces.ILogin")
public class Login {

    public String logout() {
        return "Logged Out";
        /*TO DO*/
    }

    public User authenticate(String email, String password) {
        String status = "";
        try {
            UsersDao usersDao = UsersDao.getUsersDaoInstance();
            Boolean isUserRegistered = usersDao.isUserExists(email);
            if (!isUserRegistered) {
                return new User();
            }
            // Convert Password to Hash and Compare Hash
            String generatedHash = Utils.generateHash(password);
            User user = usersDao.getUserLoginDetails(email);
            if (Arrays.equals(generatedHash.getBytes(StandardCharsets.UTF_8), user.getHash())) {
                return user; //Password Matched
            }
            return new User();
        } catch (Exception e) {
            System.out.println("Authenticate Method Error");
        }
        return new User();
    }

    public User registerUser(String name, String email, String password) {
        String status = "";
        try {
            UsersDao usersDao = UsersDao.getUsersDaoInstance();
            Boolean isUserRegistered = usersDao.isUserExists(email);
            if (isUserRegistered) {
                return new User();
            }
            // Convert Password to Hash and Compare Hash
            String generatedHash = Utils.generateHash(password);
            byte[] hashBytes = generatedHash.getBytes(StandardCharsets.UTF_8);
            User user = new User(-1, name, email, false,hashBytes, -1);
            int creationStatus = usersDao.createUserAccount(user);
            if (creationStatus == 1) {
                return user; //User Created
            }
            return new User();
        } catch (Exception e) {
            System.out.println("Register User Method Error");
        }
        return new User();
    }
}
