package com.jyujyu.review.controller.response;

import java.time.ZonedDateTime;
import java.util.List;

import com.jyujyu.review.domain.Restaurant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class RestaurantInfoResponse {
	private Long id;
	private String name;
	private String address;
	private ZonedDateTime createdAt;
	private ZonedDateTime updatedAt;
	private List<RestaurantMenuResponse> menus;

	public static RestaurantInfoResponse from(Restaurant restaurant) {
		List<RestaurantMenuResponse> menuResponses = restaurant.getMenus().stream()
			.map(RestaurantMenuResponse::from)
			.toList();
		return RestaurantInfoResponse.builder()
			.id(restaurant.getId())
			.name(restaurant.getName())
			.address(restaurant.getAddress())
			.createdAt(restaurant.getCreateAt())
			.updatedAt(restaurant.getUpdateAt())
			.menus(menuResponses)
			.build();
	}
}
