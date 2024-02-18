package com.jyujyu.review.controller.port;

import java.util.List;

import com.jyujyu.review.controller.response.RestaurantResponse;

public interface RestaurantService {
	List<RestaurantResponse> getRestaurants();
}
