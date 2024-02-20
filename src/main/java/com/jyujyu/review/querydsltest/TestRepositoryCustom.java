package com.jyujyu.review.querydsltest;

import java.util.List;

public interface TestRepositoryCustom {

	public List<TestEntity> findAllByNameByQuerydsl(String name);
}