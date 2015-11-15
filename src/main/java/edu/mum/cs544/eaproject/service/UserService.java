package edu.mum.cs544.eaproject.service;

import edu.mum.cs544.eaproject.domain.User;

public interface UserService {
	
	void saveUser(User user);
	
	User getUser(int id);
	
}
