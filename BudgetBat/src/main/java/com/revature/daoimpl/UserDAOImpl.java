package com.revature.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.beans.User;
import com.revature.dao.UserDAO;
import com.revature.util.ConnectionUtil;

public class UserDAOImpl implements UserDAO {

	private SessionFactory sf = ConnectionUtil.getSessionFactory();

	@Override
	public User getUserById(int id) {
		User u = null;
		try (Session s = sf.openSession()) {
			// Transaction tx = s.beginTransaction();
			// b = (Book) s.get(Book.class, id); CAN cast to book, but with this overloaded
			// version it's not necessary
			u = s.get(User.class, id);
			// tx.commit();
		}
		return u;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> bookList = new ArrayList<>();
		// use a Query
		try (Session s = sf.openSession()) {
			// THIS IS HQL... REFERS TO JAVA CLASS BOOK
			bookList = s.createQuery("from User").getResultList();
		}
		return bookList;
	}

	@Override
	public boolean addUser(User book) {
		boolean added = false;
		try (Session s = sf.openSession()) {
			Transaction tx = s.beginTransaction();
			s.persist(book);// adds a new record, alternate to save()
			tx.commit();
			added = true;
		}
		return added;
	}

	@Override
	public boolean updateUser(User user) {
		boolean updated = false;
		try (Session s = sf.openSession()) {
			Transaction tx = s.beginTransaction();
			s.saveOrUpdate(user);
			tx.commit();
			updated = true;
		}
		return updated;
	}

	@Override
	public boolean deleteUser(User user) {
		boolean deleted = false;
		try (Session s = sf.openSession()) {
			Transaction tx = s.beginTransaction();
			s.delete(user);
			tx.commit();
			deleted = true;
		}
		return deleted;
	}
	
}