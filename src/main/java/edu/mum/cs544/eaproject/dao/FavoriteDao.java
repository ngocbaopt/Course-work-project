package edu.mum.cs544.eaproject.dao;

import java.util.List;

import edu.mum.cs544.eaproject.domain.Favorite;

public interface FavoriteDao extends BaseDao<Favorite> {

	Favorite getFavorite(int tripId, String username);
	
	List<Favorite> getAllFavorites(int tripId);
}
