package com.jyujyu.review.service.port;

import java.util.List;

import com.jyujyu.review.domain.Restaurant;

public interface RestaurantRepository {
	// List<Restaurant> getRestaurants();

	Restaurant save(Restaurant restaurant);

	List<Restaurant> getRestaurants();
}
