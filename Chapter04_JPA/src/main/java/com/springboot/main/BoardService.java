package com.springboot.main;

import java.util.List;

public interface BoardService {

	public void write(); // 자바는 기본이 default니까 public이 안나오는것

	public List<BoardDTO> list();

}
