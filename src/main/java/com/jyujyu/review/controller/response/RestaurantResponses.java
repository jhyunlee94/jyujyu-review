package com.jyujyu.review.controller.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class RestaurantResponses {
	private List<RestaurantResponse> restaurantResponseList;

	public static RestaurantResponses from(List<RestaurantResponse> restaurantResponseList) {
		return RestaurantResponses.builder()
			.restaurantResponseList(restaurantResponseList)
			.build();
	}

}
