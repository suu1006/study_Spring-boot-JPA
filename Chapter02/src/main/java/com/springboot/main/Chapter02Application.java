package com.springboot.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "main.controller", "user.*" }) /* component:scan base-package = main.controller 이렇게 xml파일에 있던 게 여기로 작성되는것뿐! 더 잘보여서 좋다! */
public class Chapter02Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter02Application.class, args);
	}
}

/*
 * 스프링에서는 이미지를 불러올때 controller로 가지 못하게 하기 위해 
 * 스프링부트는 spring-boot-starter-web 에서 자동으로 해결해준다. 
 * 대신 src/main/resources/static 파일을 넣어주면 된다.
 * 
 */