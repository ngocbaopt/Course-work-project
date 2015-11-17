package edu.mum.cs544.eaproject.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs544.eaproject.dao.FavoriteDao;
import edu.mum.cs544.eaproject.domain.Favorite;

@Transactional
@Repository("favoriteDao")
public class FavoriteDaoImpl extends BaseDaoImpl<Favorite> implements FavoriteDao {

	@SuppressWarnings("unchecked")
	@Override
	public Favorite getFavorite(int tripId, String username) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().
				createQuery("from Favorite where tripId = :tripId and username =:username");
		query.setInteger("tripId", tripId);
		query.setString("username", username);
		List<Favorite> favorites = query.list();
		if (favorites != null & favorites.size() > 0) {
			return favorites.get(0); 
		}
		else
			return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Favorite> getAllFavorites(int tripId) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery("from Favorite where tripId = :tripId");
		query.setInteger("tripId", tripId);
		List<Favorite> favorites = query.list();
		return favorites;
	}

}
