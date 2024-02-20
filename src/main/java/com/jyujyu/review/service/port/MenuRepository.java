package com.jyujyu.review.service.port;

import java.util.Optional;

import com.jyujyu.review.domain.Menu;

public interface MenuRepository {
	Menu save(Menu menu);

	Optional<Menu> findById(Long restaurantId);
}
