package edu.mum.cs544.eaproject.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs544.eaproject.dao.UserDao;
import edu.mum.cs544.eaproject.domain.Role;
import edu.mum.cs544.eaproject.domain.Users;


@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<Users> implements UserDao {

	public UserDaoImpl() {
		System.out.println("Constructor UserDaoImpl");
	}

	@Override
	@Transactional
	public void saveUserAndRole(Role role) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(role);
		this.sessionFactory.getCurrentSession().flush();
	}
}
