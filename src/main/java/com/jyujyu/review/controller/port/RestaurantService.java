package com.jyujyu.review.controller.port;

import java.util.List;

import com.jyujyu.review.controller.response.RestaurantListResponse;
import com.jyujyu.review.domain.Restaurant;
import com.jyujyu.review.domain.RestaurantCreate;

public interface RestaurantService {
	// List<RestaurantResponse> getRestaurants();

	Restaurant create(RestaurantCreate restaurantCreate);

	List<RestaurantListResponse> getRestaurants();

	Restaurant getRestaurant(Long restaurantId);
}
