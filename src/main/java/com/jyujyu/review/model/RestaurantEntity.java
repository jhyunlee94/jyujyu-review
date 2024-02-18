package com.jyujyu.review.model;

import java.time.ZonedDateTime;

import com.jyujyu.review.domain.Restaurant;

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
@Table(name = "restaurant")
@Entity
public class RestaurantEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "address")
	private String address;

	@Column(name = "create_at")
	private ZonedDateTime createAt;

	@Column(name = "update_at")
	private ZonedDateTime updateAt;

	/**
	 * fromModel() 메서드는 Restaurant 객체를 받아서
	 * RestaurantEntity 객체로 변환하고,
	 * toModel() 메서드는 RestaurantEntity 객체를 받아서
	 * Restaurant 객체로 변환합니다.
	 * */
	public static RestaurantEntity fromModel(Restaurant restaurant) {
		RestaurantEntity restaurantEntity = new RestaurantEntity();
		restaurantEntity.id = restaurant.getId();
		restaurantEntity.name = restaurant.getName();
		restaurantEntity.address = restaurant.getAddress();
		restaurantEntity.createAt = restaurant.getCreateAt();
		restaurantEntity.updateAt = restaurant.getUpdateAt();
		return restaurantEntity;
	}

	public Restaurant toModel() {
		return Restaurant.builder()
			.id(id)
			.name(name)
			.address(address)
			.createAt(createAt)
			.updateAt(updateAt)
			.build();
	}

	@Override
	public String toString() {
		return "RestaurantEntity{" +
			"id=" + id +
			", name='" + name + '\'' +
			", address='" + address + '\'' +
			", createAt=" + createAt +
			", updateAt=" + updateAt +
			'}';
	}
}
