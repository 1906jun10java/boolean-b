package com.revature.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.beans.Budget_Goal;
import com.revature.dao.Budget_GoalDAO;
import com.revature.util.ConnectionUtil;

public class Budget_GoalDAOImpl implements Budget_GoalDAO {
	
	private SessionFactory sf = ConnectionUtil.getSessionFactory();

	@Override
	public Budget_Goal getBudget_GoalById(int id) {
		Budget_Goal bg = null;
		try (Session s = sf.openSession()) {
			// Transaction tx = s.beginTransaction();
			// b = (Book) s.get(Book.class, id); CAN cast to book, but with this overloaded
			// version it's not necessary
			bg = s.get(Budget_Goal.class, id);
			// tx.commit();
		}
		return bg;
	}

	@Override
	public List<Budget_Goal> getAllBudget_Goals() {
		List<Budget_Goal> bgList = new ArrayList<>();
		// use a Query
		try (Session s = sf.openSession()) {
			// THIS IS HQL... REFERS TO JAVA CLASS BOOK
			bgList = s.createQuery("from User").getResultList();
		}
		return bgList;
	}

	@Override
	public boolean addBudget_Goal(Budget_Goal budgetGoal) {
		boolean added = false;
		try (Session s = sf.openSession()) {
			Transaction tx = s.beginTransaction();
			s.persist(budgetGoal);// adds a new record, alternate to save()
			tx.commit();
			added = true;
		}
		return added;
	}

	@Override
	public boolean updateBudget_Goal(Budget_Goal budgetGoal) {
		boolean updated = false;
		try (Session s = sf.openSession()) {
			Transaction tx = s.beginTransaction();
			s.saveOrUpdate(budgetGoal);
			tx.commit();
			updated = true;
		}
		return updated;
	}

	@Override
	public boolean deleteBudget_Goal(Budget_Goal budgetGoal) {
		boolean deleted = false;
		try (Session s = sf.openSession()) {
			Transaction tx = s.beginTransaction();
			s.delete(budgetGoal);
			tx.commit();
			deleted = true;
		}
		return deleted;
	}
	
}
