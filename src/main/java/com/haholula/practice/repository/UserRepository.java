package com.haholula.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.haholula.practice.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}

