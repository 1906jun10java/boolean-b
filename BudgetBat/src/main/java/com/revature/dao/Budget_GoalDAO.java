package com.revature.dao;

import java.util.List;

import com.revature.beans.Budget_Goal;

public interface Budget_GoalDAO {
	
	public Budget_Goal getBudget_GoalById(int id);
	
	public List<Budget_Goal> getAllBudget_Goals();
	
	public boolean addBudget_Goal(Budget_Goal budgetGoal);
	
	public boolean updateBudget_Goal(Budget_Goal budgetGoal);
	
	public boolean deleteBudget_Goal(Budget_Goal budgetGoal);
}
