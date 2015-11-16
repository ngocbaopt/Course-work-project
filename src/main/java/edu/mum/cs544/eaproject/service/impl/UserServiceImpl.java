package edu.mum.cs544.eaproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs544.eaproject.dao.UserDao;
import edu.mum.cs544.eaproject.domain.Role;
import edu.mum.cs544.eaproject.domain.Users;
import edu.mum.cs544.eaproject.service.UserService;
import edu.mum.cs544.eaproject.util.Utils;

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
		Users encodedUser = Utils.encodePassword(user);
		userDao.save(encodedUser);
	}

	@Override
	public Users getUser(int id) {
		// TODO Auto-generated method stub
		return userDao.get(id);
	}

	@Override
	public void saveRole(Role role) {
		// TODO Auto-generated method stub
		userDao.saveRole(role);
	}

	@Override
	public Role getRole(String role) {
		// TODO Auto-generated method stub
		return userDao.getRole(role);
	}
	
}
