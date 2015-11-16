package edu.mum.cs544.eaproject.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author baopham
 *
 */

@Entity
public class Trip {

	@Id
	@GeneratedValue
	private int id;
	
	@Lob
	private String tripText;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date createDate = new Date();
	
	@ManyToOne()
	@JoinColumn(name="username")
	private Users user;
	
	@OneToMany
	@JoinColumn(name="tripId")
	private List<Comment> comments = new ArrayList<Comment>();
	
	public Trip() {
		
	}
	
	public Trip(String tripText, Users user) {
		this.tripText = tripText;
		this.user = user;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the tripText
	 */
	public String getTripText() {
		return tripText;
	}

	/**
	 * @param tripText the tripText to set
	 */
	public void setTripText(String tripText) {
		this.tripText = tripText;
	}

	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the user
	 */
	public Users getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(Users user) {
		this.user = user;
	}

	/**
	 * @return the comments
	 */
	public List<Comment> getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	
	
}
