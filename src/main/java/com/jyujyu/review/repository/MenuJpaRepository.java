package com.jyujyu.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jyujyu.review.model.RestaurantMenuEntity;

public interface MenuJpaRepository extends JpaRepository<RestaurantMenuEntity, Long> {
	// @Query("SELECT rm FROM RestaurantMenuEntity rm " +
	// 	"WHERE rm.menu_id = :restaurantId ")
	// List<RestaurantMenuEntity> findAllByMenuId(Long restaurantId);
}
