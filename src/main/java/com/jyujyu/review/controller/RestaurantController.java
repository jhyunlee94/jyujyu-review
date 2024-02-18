package com.jyujyu.review.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jyujyu.review.controller.port.RestaurantService;
import com.jyujyu.review.controller.response.RestaurantResponses;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class RestaurantController {

	private final RestaurantService restaurantService;

	// 맛집 리스트 가져오기

	/**
	 *[
	 *     {
	 *         "id": 1,
	 *         "name": "매장 이름",
	 *         "address": "매장 주소",
	 *         "createAt": "2024-02-15T07:42:56Z",
	 *         "updateAt": "2024-02-15T07:42:56Z"
	 *     },,,
	 * ]
	 * */
	// @GetMapping("/restaurants")
	// public ResponseEntity<List<RestaurantResponse>> getRestaurants() {
	// 	return ResponseEntity
	// 		.ok()
	// 		.body(restaurantService.getRestaurants());
	// }

	/**
	 *{
	 *     "restaurantResponseList": [
	 *         {
	 *             "id": 1,
	 *             "name": "매장 이름",
	 *             "address": "매장 주소",
	 *             "createAt": "2024-02-15T07:42:56Z",
	 *             "updateAt": "2024-02-15T07:42:56Z"
	 *         },
	 *         {
	 *             "id": 2,
	 *             "name": "매장 이름2",
	 *             "address": "매장 주소2",
	 *             "createAt": "2024-02-15T07:43:05Z",
	 *             "updateAt": "2024-02-15T07:43:05Z"
	 *         }
	 *     ]
	 * }
	 * */
	@GetMapping("/restaurants")
	public ResponseEntity<RestaurantResponses> getRestaurants() {
		return ResponseEntity
			.ok()
			.body(RestaurantResponses.from(restaurantService.getRestaurants()));
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
