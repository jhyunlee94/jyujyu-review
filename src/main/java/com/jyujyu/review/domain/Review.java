package com.jyujyu.review.domain;

import java.time.ZonedDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Review {
	private final Long id;
	private final Long restaurantId;
	private final String content;
	private final Double score;
	private final ZonedDateTime createdAt;

	@Builder
	public Review(Long id, Long restaurantId, String content, Double score, ZonedDateTime createdAt) {
		this.id = id;
		this.restaurantId = restaurantId;
		this.content = content;
		this.score = score;
		this.createdAt = createdAt;
	}
}
