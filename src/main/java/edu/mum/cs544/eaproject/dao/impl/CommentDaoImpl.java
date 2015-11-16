package edu.mum.cs544.eaproject.dao.impl;

/**
 * @author baopham
 */

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs544.eaproject.dao.CommentDao;
import edu.mum.cs544.eaproject.domain.Comment;

@Repository("commentDao")
@Transactional
public class CommentDaoImpl extends BaseDaoImpl<Comment> implements CommentDao {

	public List<Comment> getCommentsByTrip(int id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Comment where tripId = :tripId");
		query.setInteger("tripId", id);
		@SuppressWarnings("unchecked")
		List<Comment> comments = query.list();
		return comments;
	}
}
