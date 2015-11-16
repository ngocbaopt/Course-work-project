package edu.mum.cs544.eaproject.dao.impl;

/**
 * @author baopham
 */

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs544.eaproject.dao.TripDao;
import edu.mum.cs544.eaproject.domain.Trip;

@Repository("tripDao")
@Transactional
public class TripDaoImpl extends BaseDaoImpl<Trip> implements TripDao {

	@SuppressWarnings("unchecked")
	public List<Trip> getAllTrips() {
		Query query = sessionFactory.getCurrentSession().createQuery("from Trip");
		List<Trip> trips = query.list();
		return trips;
	}
}
