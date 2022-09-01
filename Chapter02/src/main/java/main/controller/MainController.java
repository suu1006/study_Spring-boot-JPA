package main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*@RestController - json 으로 반환하기 때문에 JSP파일이 호출안된다. */
@Controller /* 컨트롤러로 지정해야 jsp로 가져간다. */
public class MainController {

	@GetMapping(value="/")
	public String index() {
		return "/index";
	}
}
