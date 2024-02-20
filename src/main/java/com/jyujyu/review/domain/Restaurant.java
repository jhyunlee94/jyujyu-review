package com.jyujyu.review.domain;

import java.time.ZonedDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Restaurant {
	private final Long id;
	private final String name;
	private final String address;
	private final ZonedDateTime createdAt;
	private final ZonedDateTime updatedAt;
	private final List<Menu> menus;

	@Builder
	public Restaurant(Long id, String name, String address, ZonedDateTime createdAt, ZonedDateTime updatedAt,
		List<Menu> menus) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.menus = menus;
	}

}
