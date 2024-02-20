package com.jyujyu.review.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.jyujyu.review.domain.Restaurant;
import com.jyujyu.review.model.RestaurantEntity;
import com.jyujyu.review.service.port.RestaurantRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class RestaurantRepositoryImpl implements RestaurantRepository {
	private final RestaurantJpaRepository restaurantJpaRepository;

	// @Override
	// public List<Restaurant> getRestaurants() {
	// 	return restaurantJpaRepository.findAll().stream().map(RestaurantEntity::toModel).toList();
	// }

	@Override
	public List<Restaurant> getRestaurants() {
		return restaurantJpaRepository.findAll().stream().map(RestaurantEntity::toModel).collect(Collectors.toList());
	}

	@Override
	public Optional<Restaurant> findById(Long id) {
		return restaurantJpaRepository.findById(id).map(RestaurantEntity::toModel);
	}

	@Override
	public Restaurant save(Restaurant restaurant) {
		return restaurantJpaRepository.save(RestaurantEntity.fromModel(restaurant)).toModel();
	}

}
