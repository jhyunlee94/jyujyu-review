package com.jyujyu.review.service;

import java.time.ZonedDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.jyujyu.review.controller.port.RestaurantService;
import com.jyujyu.review.controller.response.RestaurantResponse;
import com.jyujyu.review.domain.Restaurant;
import com.jyujyu.review.mock.FakeRestaurantRepository;
import com.jyujyu.review.service.port.MenuRepository;
import com.jyujyu.review.service.port.RestaurantRepository;

public class RestaurantServiceTest {

	private RestaurantServiceImpl restaurantServiceImpl;
	private RestaurantService restaurantService;
	private RestaurantRepository restaurantRepository;
	private MenuRepository menuRepository;

	@BeforeEach
	public void init() {
		// 테스트에서 사용할 고정된 시간값
		ZonedDateTime fixedTime = ZonedDateTime.parse("2024-02-15T07:42:56Z");

		// Mock 객체 생성
		restaurantRepository = Mockito.mock(RestaurantRepository.class);
		menuRepository = Mockito.mock(MenuRepository.class);
		restaurantServiceImpl = new RestaurantServiceImpl(restaurantRepository, menuRepository);
		// 객체 형태로 테스트 구성
		FakeRestaurantRepository fakeRestaurantRepository = new FakeRestaurantRepository();
		this.restaurantService = RestaurantServiceImpl.builder()
			.restaurantRepository(fakeRestaurantRepository)
			.build();
		fakeRestaurantRepository.save(Restaurant.builder()
			.id(1L)
			.name("이름1")
			.address("주소1")
			.createAt(fixedTime)
			.updateAt(fixedTime)
			.build());
		fakeRestaurantRepository.save(Restaurant.builder()
			.id(2L)
			.name("이름2")
			.address("주소2")
			.createAt(fixedTime)
			.updateAt(fixedTime)
			.build());
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

		// Mockito.when(restaurantRepository.getRestaurants()).thenReturn(List.of(
		// 	expectRestaurant1, expectRestaurant2
		// ));

		// when
		// var expectList = List.of(expectRestaurant1, expectRestaurant2).stream()
		// 	.map((list) -> new RestaurantResponse(list.getId(), list.getName(), list.getAddress(), list.getCreateAt(),
		// 		list.getUpdateAt()))
		// 	.toList();
		// List<RestaurantResponse> responses = restaurantServiceImpl.getRestaurants();

		// then
		// Assertions.assertIterableEquals(expectList, responses);
	}

	@Test
	@DisplayName("맛집 리스트 가져오기 API")
	public void getRestaurantsTest2() {
		// given
		// 테스트에서 사용할 고정된 시간값
		ZonedDateTime fixedTime = ZonedDateTime.parse("2024-02-15T07:42:56Z");

		List<RestaurantResponse> expectedList = List.of(
			RestaurantResponse.builder()
				.id(1L)
				.name("이름1")
				.address("주소1")
				.createAt(fixedTime)
				.updateAt(fixedTime)
				.build(),
			RestaurantResponse.builder()
				.id(2L)
				.name("이름2")
				.address("주소2")
				.createAt(fixedTime)
				.updateAt(fixedTime)
				.build()
		);
		// when
		// List<RestaurantResponse> actualList = restaurantService.getRestaurants();
		// then
		// Assertions.assertIterableEquals(expectedList, actualList);
	}
}
