package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class HelloController {

	public HelloController() {
		System.out.println("HelloController 기본 생성자");
	}
	
	@GetMapping("/hello") // value =  ~~~ 이렇게 써도 되고 빼도 된다. (스프링도 마찬가지) / ResponseBody를 써주지 않아도 브라우저에 뿌려준다. / 
	public String hello(String name) {
		return "안녕하세요" + name;
	}
}
