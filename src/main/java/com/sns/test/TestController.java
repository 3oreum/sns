package com.sns.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sns.post.mapper.PostMapper;

@Controller
public class TestController {
	
	@Autowired
	PostMapper postMapper;
	
	// 1. string + responseBody -> html
	@ResponseBody
	@GetMapping("/test1")
	public String test1() {
		return "Hello world";
	}
	
	// 2. map + responseBody -> json
	@ResponseBody
	@GetMapping("/test2")
	public Map<String, Object> test2(){
		Map<String, Object> map = new HashMap<>();
		map.put("d", 2);
		map.put("w", 1);
		return map;
	}
	
	// 3. JSP  -> html
	// build.grade 2줄 추
	// src/main/webapp/WEB-INF/jsp
	@GetMapping("/test3")
	public String test3() {
		return "test/test";
	}
	
	// 4. DB 연동 responseBody -> json
	// SnsApplication DB 설정 안 보는 거 제거
	// DatabaseConfig 클래스 추가
	// resources/mappers xml
	// application.yml DB 접속 정보 추가
	// logback-spring.xml 추가(쿼리 로그)
	@ResponseBody
	@GetMapping("/test4")
	public List<Map<String, Object>> test4(){
		return postMapper.selectPostList();
	}
}
