package edu.mum.cs544.eaproject.service;

import edu.mum.cs544.eaproject.domain.Role;
import edu.mum.cs544.eaproject.domain.Users;

/**
 * @author baopham
 */

public interface UserService {
	
	void saveUser(Users user);
	
	Users getUser(int id);
	
	void saveRole(Role role);
	
	Role getRole(String role);
	
}
