package com.springboot.main;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// public interface BoardDAO extends JpaRepository<BoardDTO, Long>{ } 
// int 타입으로 id값을 잡았는데, 타입을 잡을때는 가장 큰 타입만 먹히기때문에 정수형 중에 가장 큰 타입은 long이니까 Long으로 적어줘야함. 
	public interface BoardDAO extends JpaRepository<BoardDTO, Long>{ 

}
