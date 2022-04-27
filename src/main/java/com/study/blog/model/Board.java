package com.study.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob // 대용량 데이터를 다룰 때 사용
	private String content;
	
	@ColumnDefault("0")
	private int count;
	
	@CreationTimestamp
	private Timestamp createData;
	
	@ManyToOne(fetch = FetchType.EAGER) // 다대일(Many = Board, One = User)
																				 // @ManyToOne은 디폴트가 fetch = FetchType.EAGER여서 생략가능,  user테이블을 select하여 userId에 해당하는 컬럼을 가져옴
	@JoinColumn(name = "userId") //FK 이름 설정
	private User user;
	
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER) // FK생성이 아닌 reply 테이블의 board(FK)과 join하여 reply 테이블의 컬럼을 가져오기 위해 사용
																													   // @OneToMany은 디폴트가 fetch = FetchType.LAZY
	private List<Reply> reply;

}
