package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.beans.User;
import com.revature.service.UserService;

@Repository(value="userDao")
@Transactional
public class UserDaoImpl implements UserDao {
	public static ConnectionFactory cFS = ConnectionFactory.getInstance();
	private SessionFactory sessionFactory;
	
	
	// For constructor injection
	@Autowired
	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	User user = new User();
	private ArrayList<User> allUsers = new ArrayList<>();

	public UserDaoImpl() {
		System.out.println("Running UserDaoImpl in UserDaoImpl");
	}

	@Override
	public User getUserByEmail(String name) {
		return sessionFactory.getCurrentSession().get(User.class, EMAIL);
	}

	@Override
	public List<User> getUsers() {
		System.out.println("7 - running getUsers in UserDaoImpl");
		
		Session s = sessionFactory.getCurrentSession();
		List<User> users = new ArrayList<>();
		return s.createQuery("form User").getResultList();

		// TODO Use new way to implement getUsers()

		// Old way of using vanilla java for reference
//		String query = "SELECT * FROM USERS";
//		Connection connection = cFS.getConnection();
//		Statement statement = null;
//
//		try {
//			statement = connection.createStatement();
//			ResultSet rs = statement.executeQuery(query);
//			while (rs.next()) {
//				User user = new User();
//				user.setEmail(rs.getString(1));
//				user.setPassword(rs.getString(2));
//				user.setFirstname(rs.getString(3));
//				user.setLastname(rs.getString(4));
//				user.setMIncom(rs.getDouble(5));
//				user.setEmployeelevel(rs.getString(6));
//				allUsers.add(user);
//				System.out.println("Found " + user.getEmail());
//				UserService.UsersIndex.add(user.getEmail());
//
//			}
//
//		} catch (SQLException e) {
//			System.out.println("This is a SQL problem\n" + e);
//		} finally {
//			if (statement != null) {
//				statement.close();
//			}
//		}
//		return allUsers;
		return null;
	}

	@Override
	public List<User> getUsersByIncomeLevel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub

	}

}
