package edu.mum.cs544.eaproject.service;

import edu.mum.cs544.eaproject.domain.Role;
import edu.mum.cs544.eaproject.domain.Users;

public interface UserService {
	
	void saveUser(Users user);
	
	Users getUser(int id);
	
	void saveUserAndRole(Role role);
	
}
