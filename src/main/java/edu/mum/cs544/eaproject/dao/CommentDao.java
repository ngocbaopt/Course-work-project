package edu.mum.cs544.eaproject.dao;

import java.util.List;

import edu.mum.cs544.eaproject.domain.Comment;

/**
 * @author baopham
 */

public interface CommentDao extends BaseDao<Comment> {
	List<Comment> getCommentsByTrip(int id);
}
