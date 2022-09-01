package com.springboot.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDAO boardDAO;
	@Override
	public void write() {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setId("hayu");
		boardDTO.setName("jeongsu");
		boardDTO.setSubject("rainy day");
		boardDTO.setContent("집가고싶다~.~");
		
		boardDAO.save(boardDTO); // = insert 문장으로 저장하겠다.
		
	}
	@Override
	public List<BoardDTO> list() {
		return boardDAO.findAll(); // 데이터 다 끌고와
	}
}
