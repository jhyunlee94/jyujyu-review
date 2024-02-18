package com.jyujyu.review.controller.response;

import java.time.ZonedDateTime;

import com.jyujyu.review.domain.Restaurant;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RestaurantResponse {
	private Long id;
	private String name;
	private String address;
	private ZonedDateTime createAt;
	private ZonedDateTime updateAt;

	public static RestaurantResponse from(Restaurant restaurant) {
		return RestaurantResponse.builder()
			.id(restaurant.getId())
			.name(restaurant.getName())
			.address(restaurant.getAddress())
			.createAt(restaurant.getCreateAt())
			.updateAt(restaurant.getUpdateAt())
			.build();
	}

	@Override
	public String toString() {
		return "RestaurantResponse{" +
			"id=" + id +
			", name='" + name + '\'' +
			", address='" + address + '\'' +
			", createAt=" + createAt +
			", updateAt=" + updateAt +
			'}';
	}
}
