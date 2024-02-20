package com.jyujyu.review.querydsltest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class TestQuerydslApi {
	private final TestService testService;

	@GetMapping("/test/query/jpa")
	public List<TestEntity> queryJpa() {
		return testService.findAllByNameByJPA("jyujyu");
	}

	@GetMapping("/test/query/querydsl")
	public List<TestEntity> queryQuerydsl() {
		return testService.findAllByNameByQuerydsl("jyujyu");
	}
}