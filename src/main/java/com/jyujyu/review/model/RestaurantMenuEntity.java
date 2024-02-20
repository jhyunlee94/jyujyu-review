package com.jyujyu.review.model;

import java.time.ZonedDateTime;

import com.jyujyu.review.domain.Menu;

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

	@Column(name = "restaurant_id") // 직접참조 사용할지 모르겠음
	private Long restaurantId;

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private Integer price;

	@Column(name = "create_at")
	private ZonedDateTime createAt;

	@Column(name = "update_at")
	private ZonedDateTime updateAt;

	public static RestaurantMenuEntity fromModel(Menu menu) {
		RestaurantMenuEntity restaurantMenuEntity = new RestaurantMenuEntity();
		restaurantMenuEntity.id = menu.getId();
		restaurantMenuEntity.restaurantId = menu.getRestaurantId();
		restaurantMenuEntity.name = menu.getName();
		restaurantMenuEntity.price = menu.getPrice();
		restaurantMenuEntity.createAt = menu.getCreateAt();
		restaurantMenuEntity.updateAt = menu.getUpdateAt();
		return restaurantMenuEntity;
	}

	public Menu toModel() {
		return Menu.builder()
			.id(id)
			.restaurantId(restaurantId)
			.name(name)
			.price(price)
			.createAt(createAt)
			.updateAt(updateAt)
			.build();
	}
}
