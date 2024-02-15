package com.jyujyu.review.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class ReviewController {

	// 리뷰 작성
	@PostMapping("/review")
	public String create() {
		return "create review";
	}

	// 리뷰 삭제
	@DeleteMapping("/review/{reviewId}")
	public String delete(
		@PathVariable Long reviewId
	) {
		return "delete review";
	}

	// 맛집에 등록된 리뷰 가져오기
	@GetMapping("/restaurant/{restaurantId}/reviews")
	public String getRestaurantReviews(
		@PathVariable Long restaurantId
	) {
		return "맛집에 등록된 리뷰 가져오기";
	}
}
