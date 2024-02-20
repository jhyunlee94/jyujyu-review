package com.jyujyu.review.model;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.BatchSize;

import com.jyujyu.review.domain.Restaurant;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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

	@OneToMany(cascade = CascadeType.ALL)
	@BatchSize(size = 20)
	@JoinColumn(name = "menu_id")
	private final List<RestaurantMenuEntity> menus = new ArrayList<>();

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
		// Restaurant의 menus를 RestaurantMenuEntity로 변환하여 menus 리스트에 추가
		List<RestaurantMenuEntity> menuEntities = restaurant.getMenus().stream()
			.map(RestaurantMenuEntity::fromModel)
			.toList();
		restaurantEntity.menus.addAll(menuEntities);

		return restaurantEntity;
	}

	public Restaurant toModel() {
		return Restaurant.builder()
			.id(id)
			.name(name)
			.address(address)
			.createAt(createAt)
			.updateAt(updateAt)
			.menus(menus.stream().map(RestaurantMenuEntity::toModel)
				.toList())
			.build();
	}

	public void addRestaurantMenu(final RestaurantMenuEntity menu) {
		menus.add(menu);
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
