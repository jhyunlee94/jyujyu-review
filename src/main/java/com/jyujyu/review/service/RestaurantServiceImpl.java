package com.jyujyu.review.service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jyujyu.review.controller.port.RestaurantService;
import com.jyujyu.review.controller.response.RestaurantListResponse;
import com.jyujyu.review.domain.Menu;
import com.jyujyu.review.domain.Restaurant;
import com.jyujyu.review.domain.RestaurantCreate;
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

	// @Override
	// public List<RestaurantResponse> getRestaurants() {
	// 	List<Restaurant> list = restaurantRepository.getRestaurants();
	// 	// return list.stream().map((response) -> RestaurantResponse.from(response)).toList();
	// 	return list.stream().map(RestaurantResponse::from).toList();
	// }
	@Override
	public List<RestaurantListResponse> getRestaurants() {
		List<Restaurant> list = restaurantRepository.getRestaurants();
		return list.stream().map(RestaurantListResponse::from).toList();
	}

	@Override
	public Restaurant create(RestaurantCreate request) {
		List<Menu> menus = new ArrayList<>();
		request.getMenus().forEach((menu) -> {
			Menu menu1 = Menu.builder()
				.name(menu.getName())
				.price(menu.getPrice())
				.createAt(ZonedDateTime.now())
				.updateAt(ZonedDateTime.now())
				.build();
			menus.add(menu1);
		});
		Restaurant restaurant = Restaurant.builder()
			.name(request.getName())
			.address(request.getAddress())
			.createAt(ZonedDateTime.now())
			.updateAt(ZonedDateTime.now())
			.menus(menus)
			.build();

		restaurantRepository.save(restaurant);

		return restaurant;
	}

}
