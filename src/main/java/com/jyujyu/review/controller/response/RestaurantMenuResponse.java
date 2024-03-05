package com.jyujyu.review.controller.response;

import java.time.ZonedDateTime;

import com.jyujyu.review.domain.Menu;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class RestaurantMenuResponse {
	private final Long id;
	private final Long restaurantId;
	private final String name;
	private final Integer price;
	private final ZonedDateTime createdAt;
	private final ZonedDateTime updatedAt;

	public static RestaurantMenuResponse from(Menu menu) {
		return RestaurantMenuResponse.builder()
			.id(menu.getId())
			.restaurantId(menu.getRestaurantId())
			.name(menu.getName())
			.price(menu.getPrice())
			.createdAt(menu.getCreatedAt())
			.updatedAt(menu.getUpdatedAt())
			.build();
	}
}
