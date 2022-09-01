package com.springboot.main;


import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity // mysql과 관계있게끔 설정됨
@Table(name="board") // 이 설정을 하지 않으면 table이름이 boardDTO 로 되는데, table이름은board로 할것이라고 알려줘야함
@Data
public class BoardDTO { 
	
	@Id //@Id 로 설정하면 primary key로 설정된다.
	//특정 데이터베이스에 맞게 자동으로 생성하는 방식, 자동으로 시퀀스 테이블이 생성된다
	@GeneratedValue(strategy = GenerationType.AUTO) // mysql이면 그거대로 , oracle이면 그거대로 너가 알아서 설정해! 
	@Column(name="seq") // 컬럼명은 seq에요
	private int seq; // seq 객체 생성 1,2,3,4...
	//@Id // = 나는 기본키에요!(=primary key) // 테이블마다 primary key는 한개만 지정할 수 있음.
	@Column(name="id", nullable=false, unique=true, length=30) // nullable = not null unique - 반복되지말아라 // id varchar(30) not null, unique >>sql문장으로 바뀜
	private String id;
	
	@Column(name = "name", nullable=false, length=30)
	private String name;
	
	@Column(name = "subject")
	private String subject;
	
	@Column(name = "content")
	private String content;
	
	@CreationTimestamp // 엔티티가 생성되는 시점의 시간 등록
	private Timestamp logtime;
}
