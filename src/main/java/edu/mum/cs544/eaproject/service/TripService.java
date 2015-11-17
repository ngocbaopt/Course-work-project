package edu.mum.cs544.eaproject.service;

/**
 * @author baopham
 */
import java.util.List;

import edu.mum.cs544.eaproject.domain.Comment;
import edu.mum.cs544.eaproject.domain.Favorite;
import edu.mum.cs544.eaproject.domain.Trip;

public interface TripService {
	
	List<Trip> getAllTrips();
	
	void saveTrip(Trip trip);
	
	void deleteTrip(int tripId);
	
	void updateTrip(Trip trip);
	
	Trip getTrip(int id);
	
	void saveComment(Comment comment);
	
	void deleteComment(int id);
	
	Comment getComment(int id);
	
	void updateComment(Comment comment);
	
	void addFavorite(Favorite favorite);
	
	void deleteFavorite(int id);
	
	Favorite getFavorite(int tripId, String username);
}
