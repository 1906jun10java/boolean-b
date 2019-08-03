package com.revature.dao;

import java.util.List;

import com.revature.beans.User;

public interface UserDao {
	public User getUserByEmail(String name);
	public List<User> getUsers();
	public List<User> getUsersByIncomeLevel();
	public boolean createUser(User user);
	public void updateUser(User user);
	public void deleteUser(User user);
}