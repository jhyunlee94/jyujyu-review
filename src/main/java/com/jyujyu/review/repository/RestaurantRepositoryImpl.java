package com.jyujyu.review.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jyujyu.review.domain.Restaurant;
import com.jyujyu.review.model.RestaurantEntity;
import com.jyujyu.review.service.port.RestaurantRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class RestaurantRepositoryImpl implements RestaurantRepository {
	private final RestaurantJpaRepository restaurantJpaRepository;

	@Override
	public List<Restaurant> getRestaurants() {
		return restaurantJpaRepository.findAll().stream().map(RestaurantEntity::toModel).toList();
	}

}
