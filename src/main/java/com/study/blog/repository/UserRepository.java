package com.study.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.study.blog.model.User;

// DAO
// 자동으로 bean으로 등록
@Repository // 생략가능
public interface UserRepository extends JpaRepository<User, Integer> {
	
	
	
}

//	@Query(value = "SELECT * FROM user WHERE username = ?1 AND password = ?2", nativeQuery = true)
//	User login (String username, String password);
// JPA Naming 쿼리
//User findByUsernameAndPassword(String username, String password);