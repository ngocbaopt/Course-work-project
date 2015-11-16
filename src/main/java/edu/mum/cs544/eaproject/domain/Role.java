
package edu.mum.cs544.eaproject.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * @author baopham
 *
 */
@Entity
public class Role {

	@Id
	private String role;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "authorities", joinColumns = { @JoinColumn(name = "authority") }, inverseJoinColumns = {
	@JoinColumn(name = "username") })
	private List<Users> users = new ArrayList<Users>();

	public Role() {
	}

	public Role(String role) {
		this.role = role;
	}
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	public void grantUser(Users user) {
		this.users.add(user);
	}

	public void removeAuthority(Users user) {
		this.users.remove(user);
	}

	/**
	 * @return the users
	 */
	public List<Users> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(List<Users> users) {
		this.users = users;
	}
	
	
}
