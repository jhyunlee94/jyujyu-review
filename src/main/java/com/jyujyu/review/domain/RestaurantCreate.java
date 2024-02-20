package com.jyujyu.review.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RestaurantCreate {
	private final String name;

	private final String address;
	private final List<CreateRequestMenu> menus;

	@Getter
	@Builder
	@AllArgsConstructor
	public static class CreateRequestMenu {
		private final String name;
		private final Integer price;
	}

	@Override
	public String toString() {
		return "RestaurantCreate{" +
			"name='" + name + '\'' +
			", address='" + address + '\'' +
			", menus=" + menus +
			'}';
	}
}
