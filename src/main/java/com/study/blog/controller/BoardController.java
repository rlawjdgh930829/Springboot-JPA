package com.study.blog.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.study.blog.config.auth.PrincipalDetail;

@Controller
public class BoardController {
	
	@GetMapping({"", "/"})
	public String index(@AuthenticationPrincipal PrincipalDetail principal) {
		System.out.println("로그인 사용자: " + principal.getUsername());
		return "index";
	}

}
