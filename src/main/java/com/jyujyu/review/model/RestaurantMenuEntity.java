package com.jyujyu.review.model;

import java.time.ZonedDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "menu")
@Entity
public class RestaurantMenuEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "restaurant_id")
	private Long restaurantId;

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private Integer price;

	@Column(name = "create_at")
	private ZonedDateTime createAt;

	@Column(name = "update_at")
	private ZonedDateTime updateAt;
}
