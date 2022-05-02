package com.study.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.blog.model.User;
import com.study.blog.repository.UserRepository;

@Service // 스프링이 컴포넌트 스캔을 통해 bean에 등록해줌(IoC)
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void 회원가입(User user) {
		userRepository.save(user);
	}

}
