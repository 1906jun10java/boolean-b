package com.revature.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.beans.Budget_Actual;
import com.revature.beans.User;
import com.revature.dao.Budget_ActualDAO;
import com.revature.dao.UserDAO;
import com.revature.util.ConnectionUtil;

public class Budget_ActualDAOImpl implements Budget_ActualDAO {

	private SessionFactory sf = ConnectionUtil.getSessionFactory();

	@Override
	public Budget_Actual getBudget_ActualById(int id) {
		Budget_Actual ba = null;
		try (Session s = sf.openSession()) {
			// Transaction tx = s.beginTransaction();
			// b = (Book) s.get(Book.class, id); CAN cast to book, but with this overloaded
			// version it's not necessary
			ba = s.get(Budget_Actual.class, id);
			// tx.commit();
		}
		return ba;
	}

	@Override
	public List<Budget_Actual> getAllBudget_Actuals() {
		List<Budget_Actual> baList = new ArrayList<>();
		// use a Query
		try (Session s = sf.openSession()) {
			// THIS IS HQL... REFERS TO JAVA CLASS BOOK
			baList = s.createQuery("from User").getResultList();
		}
		return baList;
	}

	@Override
	public boolean addBudget_Actual(Budget_Actual budgetActual) {
		boolean added = false;
		try (Session s = sf.openSession()) {
			Transaction tx = s.beginTransaction();
			s.persist(budgetActual);// adds a new record, alternate to save()
			tx.commit();
			added = true;
		}
		return added;
	}

	@Override
	public boolean updateBudget_Actual(Budget_Actual budgetActual) {
		boolean updated = false;
		try (Session s = sf.openSession()) {
			Transaction tx = s.beginTransaction();
			s.saveOrUpdate(budgetActual);
			tx.commit();
			updated = true;
		}
		return updated;
	}

	@Override
	public boolean deleteBudget_Actual(Budget_Actual budgetActual) {
		boolean deleted = false;
		try (Session s = sf.openSession()) {
			Transaction tx = s.beginTransaction();
			s.delete(budgetActual);
			tx.commit();
			deleted = true;
		}
		return deleted;
	}
	
}