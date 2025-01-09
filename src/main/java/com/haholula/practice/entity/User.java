package com.haholula.practice.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Column(name = "user_id", unique = true)
  private String userId;

  @NotBlank
  @Column(name = "user_pw")
  private String userPw;

  @NotBlank
  @Column(name = "user_email")
  private String userEmail;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  // public User() {
  //   this.createdAt = LocalDateTime.now();
  // }

  @Override
  public String toString() {
    return "User : id=" + userId + " pw=" + userPw + " email=" + userEmail;
  }
}
