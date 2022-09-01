package main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RestController - json으로 반환하기 때문에 JSP 파일이 호출 안된다.
public class MainController {
	
	@GetMapping(value="/")
	public String index() {
		return "/index";
	}
}


