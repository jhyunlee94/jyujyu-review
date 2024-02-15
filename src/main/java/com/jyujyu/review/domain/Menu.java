package com.jyujyu.review.domain;

import java.time.ZonedDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Menu {
	private final Long id;
	private final Long restaurantId;
	private final String name;
	private final Integer price;
	private final ZonedDateTime createAt;
	private final ZonedDateTime updateAt;

	@Builder
	public Menu(Long id, Long restaurantId, String name, Integer price, ZonedDateTime createAt,
		ZonedDateTime updateAt) {
		this.id = id;
		this.restaurantId = restaurantId;
		this.name = name;
		this.price = price;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}

}
