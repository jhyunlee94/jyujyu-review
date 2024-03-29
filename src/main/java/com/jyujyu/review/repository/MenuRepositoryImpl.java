package com.jyujyu.review.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.jyujyu.review.domain.Menu;
import com.jyujyu.review.model.RestaurantMenuEntity;
import com.jyujyu.review.service.port.MenuRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MenuRepositoryImpl implements MenuRepository {
	private final MenuJpaRepository menuJpaRepository;

	@Override
	public Menu save(Menu menu) {
		return menuJpaRepository.save(RestaurantMenuEntity.fromModel(menu)).toModel();
	}

	@Override
	public Optional<Menu> findById(Long id) {
		return menuJpaRepository.findById(id).map(RestaurantMenuEntity::toModel);
	}

}
