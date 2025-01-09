package com.haholula.practice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haholula.practice.entity.User;
import com.haholula.practice.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "${FRONT_URL}", allowCredentials = "true")
@RestController
@AllArgsConstructor
@RequestMapping("/users")
@Slf4j
public class UserController {
  private final UserService userService;

  @GetMapping("find-all")
  public List<User> getUsers() {
    log.debug("유저 요청");
    return userService.findAll();
  }

  @PostMapping("save")
  public void saveUser(@RequestBody User user) {
    log.debug("유저 저장 > id : {}, pw : {}, email : {}", user.getUserId(), user.getUserPw(), user.getUserEmail());
    userService.save(user);
  }

  @DeleteMapping("delete/{id}")
  public String deleteUser(@PathVariable("id") Long id) {
    log.debug("유저 삭제 > id : {}", id);
    userService.deleteById(id);
    return id + "삭제 완료";
  }

  @PostMapping("login")
  public ResponseEntity<Map<String, String>> loginUser(@RequestBody User user, HttpServletRequest request) {
    HttpSession session = request.getSession();
    User findUser = userService.findByUserIdAndUserPw(user.getUserId(), user.getUserPw());
    Map<String, String> response = new HashMap<>();
    if (findUser != null) {
      session.setAttribute("userId", user.getUserId());
      response.put("success", "true");
      return new ResponseEntity<>(response, HttpStatus.OK);
    } else {
      response.put("success", "false");
      return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }
  }
}
