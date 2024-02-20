package com.jyujyu.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jyujyu.review.model.RestaurantMenuEntity;

public interface MenuJpaRepository extends JpaRepository<RestaurantMenuEntity, Long> {

}
