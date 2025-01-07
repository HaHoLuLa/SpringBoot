package com.haholula.practice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.haholula.practice.entity.User;
import com.haholula.practice.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
  private final UserRepository userRepository;

  public void save(User user) {
    userRepository.save(user);
  }

  public List<User> findAll() {
    return userRepository.findAll();
  }

  public void deleteById(Long id) {
    userRepository.deleteById(id);
  }
}
