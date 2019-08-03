package com.revature.dao;

import java.util.List;

import com.revature.beans.User;

public interface UserDAO {

	public User getUserByEmail(int email);
	
	public List<User> getAllUsers();
	
	public boolean addUser(User book);

	public boolean updateUser(User book);
	
	public boolean deleteUser(User book);
	
}
