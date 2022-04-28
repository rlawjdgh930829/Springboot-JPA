package com.study.blog.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.blog.model.RoleType;
import com.study.blog.model.User;
import com.study.blog.repository.UserRepository;

@RestController
public class DummyController {
	
	@Autowired // 의존성 주입(DI)
	private UserRepository userRepository;
	
	@PostMapping("/dummy/join")
	public String join(User user) {
		System.out.println("id: " + user.getId());
		System.out.println("username: " + user.getUsername());
		System.out.println("password: " + user.getPassword());
		System.out.println("email: " + user.getEmail());
		System.out.println("role: " + user.getRole());
		System.out.println("createDate: " + user.getCreateDate());
		
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "회원가입이 완료 되었습니다";
	}

}
