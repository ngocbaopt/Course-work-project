package edu.mum.cs544.eaproject.service;

/**
 * @author baopham
 */
import java.util.List;

import edu.mum.cs544.eaproject.domain.Comment;
import edu.mum.cs544.eaproject.domain.Trip;

public interface TripService {
	
	List<Trip> getAllTrips();
	
	void saveTrip(Trip trip);
	
	void deleteTrip(Trip trip);
	
	void updateTrip(Trip trip);
	
	Trip getTrip(int id);
	
	void saveComment(Comment comment);
	
	void deleteComment(Comment comment);
	
	Comment getComment(int id);
}
