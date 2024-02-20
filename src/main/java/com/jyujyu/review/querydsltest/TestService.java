package com.jyujyu.review.querydsltest;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TestService {
	private final TestRepository testRepository;
	
	public List<TestEntity> findAllByNameByJPA(String name) {
		return testRepository.findAllByName(name);
	}

	public List<TestEntity> findAllByNameByQuerydsl(String name) {
		return testRepository.findAllByNameByQuerydsl(name);
	}
}