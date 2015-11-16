package edu.mum.cs544.eaproject.dao;

import edu.mum.cs544.eaproject.domain.Role;
import edu.mum.cs544.eaproject.domain.Users;

public interface UserDao extends BaseDao<Users>{

	void saveUserAndRole(Role role);
}
