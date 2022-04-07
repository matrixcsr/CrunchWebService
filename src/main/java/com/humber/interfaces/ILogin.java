/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.humber.interfaces;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author Chaitanya
 */
@WebService
public interface ILogin {
    @WebMethod(operationName = "authenticate")
    public String authenticate(String email, String password);
    
    @WebMethod(operationName = "registerUser")
    public String registerUser(String name, String email, String password);

    @WebMethod(operationName = "logout")
    public String logout();
}
