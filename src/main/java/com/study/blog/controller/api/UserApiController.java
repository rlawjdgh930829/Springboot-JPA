package com.study.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.blog.dto.ResponseDTO;
import com.study.blog.model.User;
import com.study.blog.service.UserService;

@RestController
public class UserApiController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/auth/joinProc")
	public ResponseDTO<Integer> save(@RequestBody User user) {
		System.out.println("UserApiController save메소드 호출됨");
		userService.회원가입(user);
		return new ResponseDTO<Integer>(HttpStatus.OK.value(), 1);
	}
	
	@PutMapping("/user")
	public ResponseDTO<Integer> update(@RequestBody User user) {
		System.out.println("UserApiController update메소드 호출됨");
		userService.회원수정(user);
		// 트랜잭션이 종료되어 DB의 값은 변경되었지만
		// 세션의 값은 변경되지 않은 상태이기 때문에 직접 세션 값을 변경 해줘야함
		// 세션 등록
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return new ResponseDTO<Integer>(HttpStatus.OK.value(), 1);
	}
	
	

}
