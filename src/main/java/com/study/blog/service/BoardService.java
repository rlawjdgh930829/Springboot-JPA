package com.study.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.blog.model.Board;
import com.study.blog.model.User;
import com.study.blog.repository.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Transactional
	public void 글쓰기(Board board, User user) {
		board.setCount(0);
		board.setUser(user);
		boardRepository.save(board);
	}
	
	@Transactional(readOnly = true)
	public Page<Board> 글목록(Pageable pageable) {
		return boardRepository.findAll(pageable);
	}
	
	@Transactional(readOnly = true)
	public Board 글상세보기(int id) {
		return boardRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("글 상세보기 실패: 해당 글의 번호를 찾을 수 없습니다.");
				});
	}
	
	@Transactional
	public void 글삭제하기(int id, User user) {
		Board board = boardRepository.findById(id)
			.orElseThrow(()->{
				return new IllegalArgumentException("글 상세보기 실패: 해당 글의 번호를 찾을 수 없습니다.");
			});
		if(board.getUser().getId() != user.getId()) {
			throw new IllegalArgumentException("작성자가 아닙니다.");
		}
		boardRepository.deleteById(id);
	}
	
	@Transactional
	public void 글수정하기(int id, Board requestBoard, User user) {
		Board board = boardRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("글 찾기 실패: 해당 글의 번호를 찾을 수 없습니다.");
				});
		if(board.getUser().getId() != user.getId()) {
			throw new IllegalArgumentException("작성자가 아닙니다.");
		}
		board.setTitle(requestBoard.getTitle());
		board.setContent(requestBoard.getContent());
		//해당 메서드가 종료될 때 트랜잭션이 종료 이때 더티체킹
	}

}
