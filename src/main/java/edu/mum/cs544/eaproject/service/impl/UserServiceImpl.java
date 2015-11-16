package edu.mum.cs544.eaproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs544.eaproject.dao.UserDao;
import edu.mum.cs544.eaproject.domain.Role;
import edu.mum.cs544.eaproject.domain.Users;
import edu.mum.cs544.eaproject.service.UserService;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	public UserServiceImpl() {
		System.out.println("Constructor UserServiceImpl");
	}
	
	@Override
	public void saveUser(Users user) {
		// TODO Auto-generated method stub
		userDao.save(user);
	}

	@Override
	public Users getUser(int id) {
		// TODO Auto-generated method stub
		return userDao.get(id);
	}

	@Override
	public void saveUserAndRole(Role role) {
		// TODO Auto-generated method stub
		userDao.saveUserAndRole(role);
	}
	
}
