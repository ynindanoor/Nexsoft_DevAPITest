package service;

import java.util.UUID;

import model.User;

public class UserServiceImpl implements UserService{
	
	public User createUser(String firstName, String lastName, String email, String password, String repeatPassword) {
	
		if(firstName == null || firstName.trim().length()==0) {
		throw new IllegalArgumentException("User first name is empty");
	}
	
		
		if(lastName == null || lastName.trim().length()==0) {
		throw new IllegalArgumentException("User last name is empty");
	}
	
	
		
		return new User(firstName, lastName, email, UUID.randomUUID().toString());
	}

}
