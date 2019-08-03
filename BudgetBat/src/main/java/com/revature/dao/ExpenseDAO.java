package com.revature.dao;

import java.util.List;

import com.revature.beans.Expense;

public interface ExpenseDAO {
	
	public List<Expense> getById(int id);
	public List<Expense> getAllExpenses();
	public boolean addExpense(Expense e);
	public boolean deleteExpense(Expense e);
	

}
