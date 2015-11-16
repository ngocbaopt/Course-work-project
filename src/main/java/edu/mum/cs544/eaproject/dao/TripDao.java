package edu.mum.cs544.eaproject.dao;

import java.util.List;

import edu.mum.cs544.eaproject.domain.Trip;

/**
 * @author baopham
 */

public interface TripDao extends BaseDao<Trip> {
	
	List<Trip> getAllTrips();
}
