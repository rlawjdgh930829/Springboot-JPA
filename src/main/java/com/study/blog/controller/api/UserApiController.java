package com.study.blog.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.blog.dto.ResponseDTO;
import com.study.blog.model.RoleType;
import com.study.blog.model.User;
import com.study.blog.service.UserService;

@RestController
public class UserApiController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/auth/joinProc")
	public ResponseDTO<Integer> save(@RequestBody User user) {
		System.out.println("UserApiController save메소드 호출됨");
		userService.회원가입(user);
		return new ResponseDTO<Integer>(HttpStatus.OK.value(), 1);
	}
	
	

}
