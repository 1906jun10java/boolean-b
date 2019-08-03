package com.revature.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.beans.User;

@Repository(value = "userDao")
@Transactional
public class UserDaoImpl implements UserDao {
	public static ConnectionFactory cFS = ConnectionFactory.getInstance();
	private SessionFactory sessionFactory;

	// For constructor injection
	@Autowired
	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	

	public UserDaoImpl() {
		System.out.println("Running UserDaoImpl in UserDaoImpl");
	}

	@Override
	public User getUserByEmail(String email) {
		return sessionFactory.getCurrentSession().get(User.class, email);
	}

	@Override
	public List<User> getUsers() {
		System.out.println("7 - running getUsers in UserDaoImpl");
		Session s = sessionFactory.getCurrentSession();
		return s.createQuery("from User").getResultList();
	}

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

	@Override
	public List<User> getUsersByIncomeLevel() {
		return null;
	}

	@Override
	public void createUser(User user) {
		sessionFactory.getCurrentSession().persist(user);
	}

	

	@Override
	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);

	}

	@Override
	public void deleteUser(User user) {
		sessionFactory.getCurrentSession().delete(user);
	}

}
