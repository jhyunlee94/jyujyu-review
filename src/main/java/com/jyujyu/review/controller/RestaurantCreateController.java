package com.jyujyu.review.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jyujyu.review.controller.port.RestaurantService;
import com.jyujyu.review.controller.response.RestaurantResponse;
import com.jyujyu.review.domain.RestaurantCreate;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class RestaurantCreateController {

	private final RestaurantService restaurantService;

	// 맛집 생성
	@PostMapping("/restaurant")
	public ResponseEntity<?> create(
		@RequestBody RestaurantCreate restaurantCreate
	) {
		return ResponseEntity
			.status(HttpStatus.CREATED)
			.body(RestaurantResponse.from(restaurantService.create(restaurantCreate)));

	}
}
