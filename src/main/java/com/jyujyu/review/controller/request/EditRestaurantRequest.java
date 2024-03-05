package com.jyujyu.review.controller.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class EditRestaurantRequest {
	private final String name;
	private final String address;
	private final List<EditRestaurantRequestMenu> menus;
	
	@Getter
	@Builder
	@AllArgsConstructor
	public static class EditRestaurantRequestMenu {
		private final String name;
		private final Integer price;
	}
}
