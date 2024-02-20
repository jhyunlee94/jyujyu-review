package com.jyujyu.review.controller.response;

import java.time.ZonedDateTime;
import java.util.List;

import com.jyujyu.review.domain.Restaurant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor // mock 테스트 한다고 추가 함 추후 다른 형태로 바꿀 예정
@EqualsAndHashCode  // mock 테스트 한다고 추가 함 추후 다른 형태로 바꿀 예정
public class RestaurantResponse {
	private Long id;
	private String name;
	private String address;
	private ZonedDateTime createdAt;
	private ZonedDateTime updatedAt;
	private List<RestaurantMenuResponse> menus;

	public static RestaurantResponse from(Restaurant restaurant) {
		List<RestaurantMenuResponse> menuResponses = restaurant.getMenus().stream()
			.map(RestaurantMenuResponse::from)
			.toList();

		return RestaurantResponse.builder()
			.id(restaurant.getId())
			.name(restaurant.getName())
			.address(restaurant.getAddress())
			.createdAt(restaurant.getCreatedAt())
			.updatedAt(restaurant.getUpdatedAt())
			.menus(menuResponses)
			.build();
	}

}
