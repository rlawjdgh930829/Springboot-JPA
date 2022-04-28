package com.study.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.blog.model.User;

// DAO
// 자동으로 bean으로 등록
@Repository // 생략가능
public interface UserRepository extends JpaRepository<User, Integer> {

}
