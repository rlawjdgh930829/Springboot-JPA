package com.study.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// @Controller로 설정하면
// 기본경로: src/main/resources/static에서
// 파일을 찾아 그 파일을 리턴해줌
// 하지만 정적인 파일만 인식 가능
@Controller
public class TempControllerTest {
	
	@GetMapping("temp/home")
	public String tempHome() {
		System.out.println("tempHome()");
		return "home.html";
	}

}
