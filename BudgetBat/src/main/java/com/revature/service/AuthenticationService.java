package com.revature.service;

import java.util.ArrayList;

import com.revature.beans.Credentials;
import com.revature.beans.User;

public class AuthenticationService {
	
	public AuthenticationService() {
		
	}

	public User authenticateUser(Credentials creds) {
		System.out.println("3 - running authenticateUser from AuthenticateUser");
		UserService us = new UserService();
		User user = null;
		System.out.println("trying to getUsers from UserDaoImpl");
		UserDaoImpl udi = new UserDaoImpl();
		ArrayList<User> currentUsers = udi.getUsers();
		System.out.println("checking if entry: " + creds.getEmail() + " is in database (not checking password right now)");
		if(UserService.UsersIndex.contains(creds.getEmail()) && creds.getPassword().equals(
				UserService.Users.get(creds.getEmail()).getPassword())) {

			System.out.println(creds.getEmail() + " is in the database and password matches!!!!!!");
			user = UserService.Users.get(creds.getEmail());
			
		} else {
			System.out.println(creds.getEmail() + " was not found!!!!!!");
		}
		return user;
	}

}