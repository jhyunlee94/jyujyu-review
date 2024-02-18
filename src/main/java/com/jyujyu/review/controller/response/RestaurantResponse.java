package com.jyujyu.review.controller.response;

import java.time.ZonedDateTime;

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
