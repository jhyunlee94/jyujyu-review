package com.jyujyu.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jyujyu.review.model.ReviewEntity;

public interface ReviewJpaRepository extends JpaRepository<ReviewEntity, Long> {
}
