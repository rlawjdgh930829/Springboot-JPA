package com.study.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// @DynamicInsert insert시 null인 필드 제외
//JPA는 ORM으로 Object를 테이블로 매핑해줌
@Entity // User Class가 MySQL에 테이블을 생성
public class User {
	
	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 연결된 DB의 넘버링 전략을 따라간다(auto_increment)
	private int id;
	
	@Column(nullable = false, length = 30)
	private String username;
	
	@Column(nullable = false, length = 100) // 암호화(해시)를 하기 위해 length를 넉넉하게 설정
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;
	
	@Enumerated(EnumType.STRING) // DB는 RoleType이라는게 없어서 String이라고 명시 해줘야함
	private RoleType role; // enum(admin, user, manager)를 쓰면 타입이 강제됨
	
	@CreationTimestamp // 현재시간 자동 입력
	private Timestamp createDate;

}
