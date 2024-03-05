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
	private final ZonedDateTime createdAt;
	private final ZonedDateTime updatedAt;

	@Builder
	public Menu(Long id, Long restaurantId, String name, Integer price, ZonedDateTime createdAt,
		ZonedDateTime updatedAt) {
		this.id = id;
		this.restaurantId = restaurantId;
		this.name = name;
		this.price = price;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Menu{" +
			"id=" + id +
			", restaurantId=" + restaurantId +
			", name='" + name + '\'' +
			", price=" + price +
			", createdAt=" + createdAt +
			", updatedAt=" + updatedAt +
			'}';
	}
}
