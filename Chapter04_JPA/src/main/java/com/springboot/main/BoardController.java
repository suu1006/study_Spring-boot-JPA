package com.springboot.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // json으로 변경해준다. ㅡ스프링에서는 Controller + ResponseBody 라고 써줬다.
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping(value = "/board/write")
	public String write() {
		boardService.write(); // db에 처리하고 돌아와~
		return "게시물 등록 성공!";
	}
	
	@GetMapping(value= "/board/list")
	public List<BoardDTO> list() {
		return boardService.list();
	}
}
