package com.jyujyu.review.controller;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jyujyu.review.domain.Restaurant;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class RestaurantController {

	// 맛집 리스트 가져오기
	@GetMapping("/restaurants")
	public List<Restaurant> getRestaurants() {
		return List.of(
			Restaurant.builder()
				.id(1L)
				.name("식당 이름")
				.address("식당 주소")
				.createAt(ZonedDateTime.now())
				.updateAt(ZonedDateTime.now())
				.build()
		);
	}

	// 맛집 정보 가져오기
	@GetMapping("/restaurant/{restaurantId}")
	public String getRestaurant(
		@PathVariable Long restaurantId
	) {
		return "get restaurant";
	}

	// 맛집 생성
	@PostMapping("/restaurant")
	public String create() {
		return "create restaurant";
	}

	// 맛집 수정
	@PutMapping("/restaurant/{restaurantId}")
	public String edit(
		@PathVariable Long restaurantId
	) {
		return "edit restaurant";
	}

	// 맛집 삭제
	@DeleteMapping("/restaurant/{restaurantId}")
	public String delete(
		@PathVariable Long restaurantId
	) {
		return "delete restaurant";
	}

}
