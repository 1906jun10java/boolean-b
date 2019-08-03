package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.beans.User;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;

public class UserService {
	public static ArrayList<String> UsersIndex = new ArrayList<>();

	
	
	private UserDao userDao;
	
	@Autowired
	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}
	
			
	public UserService() {
	}
	
	public List<User> getUsers() {
		System.out.println("running getUsers from UserService");
		return this.userDao.getUsers();
//		return forEveryServiceOneDaoObject.getUsers();
	}

	public User getUserByEmail(String email) {
		System.out.println("5 - running getUserByEmail from UserService");
		return this.userDao.getUserByEmail(email);
//		return forEveryServiceOneDaoObject.getUserByEmail(username);
	}

	public void createUser(User user) {
		System.out.println("running createUser from UserService");
		userDao.createUser(user);
	}
	
//	public List<User> getUsers() {
//		ArrayList<User> users = ArrayList<>();
//		User user = new User();
//		users.add()
//	}
}