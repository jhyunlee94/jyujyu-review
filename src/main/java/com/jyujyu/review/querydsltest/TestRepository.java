package com.jyujyu.review.querydsltest;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<TestEntity, Long>, TestRepositoryCustom {

	public List<TestEntity> findAllByName(String name);
}