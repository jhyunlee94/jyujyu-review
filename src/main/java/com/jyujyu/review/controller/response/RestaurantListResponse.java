package com.jyujyu.review.controller.response;

import java.time.ZonedDateTime;

import com.jyujyu.review.domain.Restaurant;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class RestaurantListResponse {
	private final Long id;
	private final String name;
	private final String address;
	private final ZonedDateTime createdAt;
	private final ZonedDateTime updatedAt;

	public static RestaurantListResponse from(Restaurant restaurant) {
		return RestaurantListResponse.builder()
			.id(restaurant.getId())
			.name(restaurant.getName())
			.address(restaurant.getAddress())
			.createdAt(restaurant.getCreateAt())
			.updatedAt(restaurant.getUpdateAt())
			.build();
	}
}
