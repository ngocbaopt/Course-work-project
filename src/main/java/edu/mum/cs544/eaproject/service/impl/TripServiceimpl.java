/**
 * 
 */
package edu.mum.cs544.eaproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs544.eaproject.dao.CommentDao;
import edu.mum.cs544.eaproject.dao.TripDao;
import edu.mum.cs544.eaproject.domain.Comment;
import edu.mum.cs544.eaproject.domain.Trip;
import edu.mum.cs544.eaproject.service.TripService;

/**
 * @author baopham
 *
 */
@Transactional
@Service("tripService")

public class TripServiceimpl implements TripService {

	@Autowired
	private TripDao tripDao;

	@Autowired
	private CommentDao commentDao;

	@Override
	public List<Trip> getAllTrips() {
		// TODO Auto-generated method stub
		List<Trip> trips = tripDao.getAllTrips();
		for (Trip trip : trips) {
			List<Comment> comments = commentDao.getCommentsByTrip(trip.getId());
			trip.setComments(comments);
		}
		return trips;
	}

	@Override
	public void saveTrip(Trip trip) {
		// TODO Auto-generated method stub
		tripDao.save(trip);
	}

	@Override
	public void deleteTrip(Trip trip) {
		// TODO Auto-generated method stub
		tripDao.delete(trip.getId());
	}

	@Override
	public void updateTrip(Trip trip) {
		// TODO Auto-generated method stub
		tripDao.update(trip);
	}

	@Override
	public Trip getTrip(int id) {
		// TODO Auto-generated method stub
		return tripDao.get(id);
	}

	@Override
	public void saveComment(Comment comment) {
		// TODO Auto-generated method stub
		commentDao.save(comment);
	}

	@Override
	public void deleteComment(Comment comment) {
		// TODO Auto-generated method stub
		commentDao.delete(comment.getId());
	}

	@Override
	public Comment getComment(int id) {
		// TODO Auto-generated method stub
		return commentDao.get(id);
	}

}
