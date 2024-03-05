package com.jyujyu.review.domain;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;

@Getter
public class RestaurantEdit {

	private final String name;
	private final String address;
	private final ZonedDateTime updatedAt;

	@Builder
	public RestaurantEdit(
		@JsonProperty("name") String name,
		@JsonProperty("address") String address,
		@JsonProperty("updatedAt") ZonedDateTime updatedAt
	) {
		this.name = name;
		this.address = address;
		this.updatedAt = ZonedDateTime.now();
	}
}
