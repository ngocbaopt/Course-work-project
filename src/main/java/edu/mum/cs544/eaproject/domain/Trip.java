package edu.mum.cs544.eaproject.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;

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
	@NotBlank
	private String tripText;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date createDate = new Date();
	
	@ManyToOne()
	@JoinColumn(name="username")
	private Users user;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="tripId")
	private List<Comment> comments = new ArrayList<Comment>();
	
	private boolean editable = false;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="tripId")
	private List<Favorite> favorites = new ArrayList<Favorite>();
	
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
	
	public void addComment(Comment comment) {
		this.comments.add(comment);
	}
	
	public void removeComment(Comment comment) {
		this.comments.remove(comment);
	}

	/**
	 * @return the editable
	 */
	public boolean isEditable() {
		return editable;
	}

	/**
	 * @param editable the editable to set
	 */
	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	/**
	 * @return the favorites
	 */
	public List<Favorite> getFavorites() {
		return favorites;
	}

	/**
	 * @param favorites the favorites to set
	 */
	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}
	
	public void addFavorite(Favorite favor) {
		this.favorites.add(favor);
	}
	
	public void removeFavorite(Favorite favor) {
		this.favorites.remove(favor);
	}
	
	public boolean isFavorite() {
		return false;
	}
}
