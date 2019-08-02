package com.revature.driver;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.beans.User;
import com.revature.dao.UserDAO;
import com.revature.daoimpl.UserDAOImpl;
import com.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {
		
		// use this to get Sessions, which will do most of the work
				
			/*SessionFactory sf = ConnectionUtil.getSessionFactory(); 
			Session s = sf.openSession(); 
			System.out.println(s.getStatistics());
			sf.openSession(); 
			System.out.println(s.getStatistics()); 
			Transaction tx = s.beginTransaction(); 
			s.save(new User(3000, "Alexandre","Dumas", "CountMC", "money", "lotsOfMoney@gmail.com"));
			tx.commit(); 
			s.close();*/
				 
		
		SessionFactory sf = ConnectionUtil.getSessionFactory();
		funWithDaos();
	}
		static void funWithDaos() {
			UserDAO bd = new UserDAOImpl();
			bd.addUser(new User(3000, "Alexandre","Dumas", "CountMC", "money", "lotsOfMoney@gmail.com"));
			/*User userToUpdate = bd.getUserById(1);
			userToUpdate.setFirstName("Matthew");
			bd.updateUser(userToUpdate);
			List<User> userList = bd.getAllUsers();
			for (User u : userList) {
				System.out.println(u);
			}*/
		}

}


