package edu.mum.cs544.eaproject.dao;

import edu.mum.cs544.eaproject.domain.Favorite;

public interface FavoriteDao extends BaseDao<Favorite> {

	Favorite getFavorite(int tripId, String username);
}
