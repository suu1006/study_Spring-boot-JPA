package board.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import board.bean.BoardDTO;

@RestController // 자연스럽게 제이슨으로 바뀐다. responsebody안써도 된다.
public class BoardController {
	
	public BoardController() {
		System.out.println("BoardController 기본생성자");
	}
	
	@GetMapping(value = "/board/hello")
	public String hello(String name) {
		return "안녕하세요" + name;
	}
	
	@GetMapping(value = "/board/getBoard")
	//@ResponseBody - 필요없다. 자바 객체가 전달되는 경우에는 자동으로 JSON으로 변환한다. RestController때문에 자동으로 바뀌기 때문.
	public BoardDTO getBoard() {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setSeq(1);
		boardDTO.setName("홍길동");
		boardDTO.setSubject("홍길동 전");
		boardDTO.setContent("동에 번쩍 서에 번쩍");
		boardDTO.setLogtime(new Date());
		
		return boardDTO;
	}
	
	@GetMapping(value = "/board/getBoardList")
	public List<BoardDTO> getBoardList() {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
	
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setSeq(1);
		boardDTO.setName("허균");
		boardDTO.setSubject("홍길동 전");
		boardDTO.setContent("동에 번쩍 서에 번쩍");
		boardDTO.setLogtime(new Date());
		
		list.add(boardDTO);
		
		boardDTO = new BoardDTO();
		boardDTO.setSeq(2);
		boardDTO.setName("김수정");
		boardDTO.setSubject("아기공룡 둘리");
		boardDTO.setContent("고길동집에서 구박 받으며 꿋꿋하게 살고있다.");
		boardDTO.setLogtime(new Date());
	
		list.add(boardDTO);
		
		return list;
	}
}
