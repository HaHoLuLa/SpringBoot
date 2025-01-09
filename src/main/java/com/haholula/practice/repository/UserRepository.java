package com.haholula.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.haholula.practice.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  @Query("select u from User u where u.userId = ?1 and u.userPw = ?2")
  User findByUserIdAndUserPw(String userId, String userPw);
}
