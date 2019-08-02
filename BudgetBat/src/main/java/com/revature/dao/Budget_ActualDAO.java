package com.revature.dao;

import java.util.List;

import com.revature.beans.Budget_Actual;

public interface Budget_ActualDAO {

	public Budget_Actual getBudget_ActualById(int id);
	
	public List<Budget_Actual> getAllBudget_Actuals();
	
	public boolean addBudget_Actual(Budget_Actual BudgetA);
	
	public boolean updateBudget_Actual(Budget_Actual BudgetA);
	
	public boolean deleteBudget_Actual(Budget_Actual BudgetA);
	
}
