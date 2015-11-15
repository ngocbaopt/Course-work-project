package edu.mum.cs544.eaproject.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs544.eaproject.dao.UserDao;
import edu.mum.cs544.eaproject.domain.User;

@Transactional
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	public UserDaoImpl() {
		System.out.println("Constructor UserDaoImpl");
	}
}
