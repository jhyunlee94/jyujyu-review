package com.jyujyu.review.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.jyujyu.review.controller.response.RestaurantResponse;
import com.jyujyu.review.domain.Restaurant;
import com.jyujyu.review.service.port.RestaurantRepository;

public class RestaurantServiceTest {

	private RestaurantServiceImpl restaurantService;
	private RestaurantRepository restaurantRepository;

	@BeforeEach
	public void init() {
		// Mock 객체 생성
		restaurantRepository = Mockito.mock(RestaurantRepository.class);
		restaurantService = new RestaurantServiceImpl(restaurantRepository);
	}

	@Test
	@DisplayName("맛집 리스트 가져오기 API Mock & @EqualsAndHashCode")
	public void getRestaurantsTest() {
		// given
		// List<Restaurant> restaurants = Arrays.asList(
		// 	Restaurant.builder().id(1L).name("이름1").address("주소1").build(),
		// 	Restaurant.builder().id(2L).name("이름2").address("주소2").build()
		// );

		Restaurant expectRestaurant1 = Restaurant.builder().id(1L).name("이름1").address("주소1").build();
		Restaurant expectRestaurant2 = Restaurant.builder().id(2L).name("이름2").address("주소2").build();

		Mockito.when(restaurantRepository.getRestaurants()).thenReturn(List.of(
			expectRestaurant1, expectRestaurant2
		));

		// when
		var expectList = List.of(expectRestaurant1, expectRestaurant2).stream()
			.map((list) -> new RestaurantResponse(list.getId(), list.getName(), list.getAddress(), list.getCreateAt(),
				list.getUpdateAt()))
			.toList();
		List<RestaurantResponse> responses = restaurantService.getRestaurants();

		// then
		Assertions.assertIterableEquals(expectList, responses);
	}

	@Test
	@DisplayName("맛집 리스트 가져오기 API")
	public void getRestaurantsTest2() {

	}
}
