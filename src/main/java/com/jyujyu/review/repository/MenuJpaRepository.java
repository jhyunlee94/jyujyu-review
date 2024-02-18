package com.jyujyu.review.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jyujyu.review.model.RestaurantMenuEntity;

public interface MenuJpaRepository extends JpaRepository<RestaurantMenuEntity, Long> {
	public List<RestaurantMenuEntity> findAllByRestaurantId(Long restaurantId);
}
