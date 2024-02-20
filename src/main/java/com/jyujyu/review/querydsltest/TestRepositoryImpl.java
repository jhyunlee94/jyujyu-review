package com.jyujyu.review.querydsltest;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class TestRepositoryImpl implements TestRepositoryCustom {
	private final JPAQueryFactory queryFactory;

	@Override
	public List<TestEntity> findAllByNameByQuerydsl(String name) {
		return queryFactory.selectFrom(QTestEntity.testEntity)
			.fetch();
	}
}