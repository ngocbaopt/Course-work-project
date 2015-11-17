package edu.mum.cs544.eaproject.dao.impl;

/**
 * @author baopham
 */

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs544.eaproject.dao.UserDao;
import edu.mum.cs544.eaproject.domain.Role;
import edu.mum.cs544.eaproject.domain.Users;

@Transactional
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<Users> implements UserDao {

	public UserDaoImpl() {
		System.out.println("Constructor UserDaoImpl");
	}

	@Override
	public void saveRole(Role role) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(role);
		this.sessionFactory.getCurrentSession().flush();
	}

	@Override
	public Role getRole(String role) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery("from Role r where r.role = :role");
		query.setString("role", role);
		@SuppressWarnings("unchecked")
		List<Role> roles = query.list();
		return roles.get(0);
	}

	@Override
	public Users getUser(String user) {
		// TODO Auto-generated method stub
		return (Users) sessionFactory.getCurrentSession().get(Users.class, user);
	}
}
