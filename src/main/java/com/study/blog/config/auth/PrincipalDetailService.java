package com.study.blog.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.study.blog.model.User;
import com.study.blog.repository.UserRepository;

@Service // 빈 등록
public class PrincipalDetailService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	// 스프링 시큐리티로 로그인할 때 username이 DB에 존재하는지 확인
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User pricipal = userRepository.findByUsername(username).orElseThrow(()->{
			return new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다. " + username);
		});
		return new PrincipalDetail(pricipal); // 시큐리티의 세션에 유저 정보가 저장됨
	}

}
