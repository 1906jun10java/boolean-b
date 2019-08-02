package com.revature.controller;

public class UserControllor {
	
	//TODO pull from example in how this is set up
	@RequestMapping(value="/{email}", method=RequestMethod.GET)
	public ReponseEntity<User> getUserByEmail(@PathVariable int id) {
		
	}

}
