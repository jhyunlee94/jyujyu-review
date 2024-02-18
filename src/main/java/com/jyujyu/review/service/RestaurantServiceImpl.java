package com.jyujyu.review.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jyujyu.review.controller.port.RestaurantService;
import com.jyujyu.review.controller.response.RestaurantResponse;
import com.jyujyu.review.domain.Restaurant;
import com.jyujyu.review.service.port.RestaurantRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RestaurantServiceImpl implements RestaurantService {

	private final RestaurantRepository restaurantRepository;

	@Override
	public List<RestaurantResponse> getRestaurants() {
		List<Restaurant> list = restaurantRepository.getRestaurants();
		// return list.stream().map((response) -> RestaurantResponse.from(response)).toList();
		return list.stream().map(RestaurantResponse::from).toList();
	}
}
