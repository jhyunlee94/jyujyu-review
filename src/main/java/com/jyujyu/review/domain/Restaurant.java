package com.jyujyu.review.domain;

import java.time.ZonedDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Restaurant {
	private final Long id;
	private final String name;
	private final String address;
	private final ZonedDateTime createAt;
	private final ZonedDateTime updateAt;

	@Builder
	public Restaurant(Long id, String name, String address, ZonedDateTime createAt, ZonedDateTime updateAt) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}

	@Override
	public String toString() {
		return "Restaurant{" +
			"id=" + id +
			", name='" + name + '\'' +
			", address='" + address + '\'' +
			", createAt=" + createAt +
			", updateAt=" + updateAt +
			'}';
	}
}
