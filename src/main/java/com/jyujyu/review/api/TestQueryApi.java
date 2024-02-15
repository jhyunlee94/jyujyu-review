package com.jyujyu.review.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jyujyu.review.model.TestEntity;
import com.jyujyu.review.service.TestService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class TestQueryApi {

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
