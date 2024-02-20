package com.jyujyu.review.service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jyujyu.review.common.domain.exception.ResourceNotFoundException;
import com.jyujyu.review.controller.port.RestaurantService;
import com.jyujyu.review.controller.request.EditRestaurantRequest;
import com.jyujyu.review.controller.response.RestaurantListResponse;
import com.jyujyu.review.domain.Menu;
import com.jyujyu.review.domain.Restaurant;
import com.jyujyu.review.domain.RestaurantCreate;
import com.jyujyu.review.model.RestaurantEntity;
import com.jyujyu.review.model.RestaurantMenuEntity;
import com.jyujyu.review.repository.MenuJpaRepository;
import com.jyujyu.review.repository.RestaurantJpaRepository;
import com.jyujyu.review.service.port.MenuRepository;
import com.jyujyu.review.service.port.RestaurantRepository;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Builder
public class RestaurantServiceImpl implements RestaurantService {

	private final RestaurantRepository restaurantRepository;
	private final MenuRepository menuRepository;
	private final RestaurantJpaRepository restaurantJpaRepository;
	private final MenuJpaRepository menuJpaRepository;

	// @Override
	// public List<RestaurantResponse> getRestaurants() {
	// 	List<Restaurant> list = restaurantRepository.getRestaurants();
	// 	// return list.stream().map((response) -> RestaurantResponse.from(response)).toList();
	// 	return list.stream().map(RestaurantResponse::from).toList();
	// }
	@Transactional
	@Override
	public List<RestaurantListResponse> getRestaurants() {
		List<Restaurant> list = restaurantRepository.getRestaurants();
		return list.stream().map(RestaurantListResponse::from).toList();
	}

	@Override
	public Restaurant getRestaurant(Long restaurantId) {
		Restaurant restaurant = restaurantRepository.findById(restaurantId)
			.orElseThrow(() -> new ResourceNotFoundException("Restaurant", restaurantId));
		System.out.println(restaurant.toString());
		// List<Menu> menus = menuRepository.findAllByMenuId(restaurantId);
		// for (Menu menu : menus) {
		// 	System.out.println(menu);
		// }
		return restaurant;
	}

	@Transactional
	@Override
	public Restaurant edit(Long restaurantId, EditRestaurantRequest request) {
		Optional<Menu> menus = menuRepository.findById(restaurantId);
		return null;
	}

	@Transactional
	@Override
	public Restaurant create(RestaurantCreate request) {
		// List<Menu> menus = new ArrayList<>();
		// request.getMenus().forEach((menu) -> {
		// 	Menu menu1 = Menu.builder()
		// 		.name(menu.getName())
		// 		.price(menu.getPrice())
		// 		.createdAt(ZonedDateTime.now())
		// 		.updatedAt(ZonedDateTime.now())
		// 		.build();
		// 	menus.add(menu1);
		// });
		// Restaurant restaurant = Restaurant.builder()
		// 	.name(request.getName())
		// 	.address(request.getAddress())
		// 	.createdAt(ZonedDateTime.now())
		// 	.updatedAt(ZonedDateTime.now())
		// 	.menus(menus)
		// 	.build();
		//
		// restaurantRepository.save(restaurant);

		RestaurantEntity restaurantEntity = RestaurantEntity.builder()
			.name(request.getName())
			.address(request.getAddress())
			.createdAt(ZonedDateTime.now())
			.updatedAt(ZonedDateTime.now())
			.build();
		restaurantJpaRepository.save(restaurantEntity);

		request.getMenus().forEach((menu) -> {
			System.out.println(restaurantEntity);
			RestaurantMenuEntity menuEntity = RestaurantMenuEntity.builder()
				.restaurant(restaurantEntity)
				.name(menu.getName())
				.price(menu.getPrice())
				.createdAt(ZonedDateTime.now())
				.updatedAt(ZonedDateTime.now())
				.build();

			System.out.println(menuEntity);
			menuJpaRepository.save(menuEntity);

		});

		// List<Menu> menus = new ArrayList<>();
		// Restaurant restaurant = Restaurant.builder()
		// 	.name(request.getName())
		// 	.address(request.getAddress())
		// 	.createdAt(ZonedDateTime.now())
		// 	.updatedAt(ZonedDateTime.now())
		// 	.build();
		//
		// restaurantRepository.save(restaurant);
		//
		// System.out.println(restaurant.getId());
		// request.getMenus().forEach((menu) -> {
		// 	Menu menu1 = Menu.builder()
		// 		.restaurantId(restaurant.getId()) // 올바른 ID를 사용
		// 		.name(menu.getName())
		// 		.price(menu.getPrice())
		// 		.createdAt(ZonedDateTime.now())
		// 		.updatedAt(ZonedDateTime.now())
		// 		.build();
		// 	menuRepository.save(menu1);
		// });

		return null;
	}

}
