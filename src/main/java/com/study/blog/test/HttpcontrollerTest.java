package com.study.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpcontrollerTest {
	
	// select
	// 인터넷 브라우저 요청은 get만 가능
	// 데이터 요청은 Query String으로만 가능 ex) id=1&username=user
	@GetMapping("/test/get")
	public String getTest(Member m) {
		return "get 요청: " + m.getId() + ", " + m.getUsername();
	}
	
	// insert
	// 데이터 요청은 RequestBody로 가능
	// MessageConverter가 알아서 parameter에 바인딩
	@PostMapping("/test/post")
	public String postTest(@RequestBody Member m) {
		return "post 요청: " + m.getId() + ", " + m.getUsername();
	}
	
	// update
	@PutMapping("/test/put")
	public String putTest(@RequestBody Member m) {
		return "put 요청" + m.getId() + ", " + m.getUsername();
	}
	
	// delete
	@DeleteMapping("/test/delete")
	public String deleteTest(@RequestBody Member m) {
		return "delete 요청" + m.getId() + ", " + m.getUsername();
	}
	
}