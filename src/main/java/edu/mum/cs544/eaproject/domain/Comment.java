
package edu.mum.cs544.eaproject.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author baopham
 */

@Entity
public class Comment {

	@Id
	@GeneratedValue
	private int id;
	
	@Lob
	@NotBlank
	private String commentText;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate = new Date();
	
	@ManyToOne
	@JoinColumn(name = "username")
	private Users user;
	
	public Comment() {
		
	}
	
	public Comment(String comment, Users user) {
		this.commentText = comment;
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
	 * @return the commentText
	 */
	public String getCommentText() {
		return commentText;
	}

	/**
	 * @param commentText the commentText to set
	 */
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	
	
}
