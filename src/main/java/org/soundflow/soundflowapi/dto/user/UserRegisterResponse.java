package org.soundflow.soundflowapi.dto.user;

import java.time.LocalDateTime;

public class UserRegisterResponse {

  private Long id;
  private String name;
  private String email;
  private String role;
  private LocalDateTime createdAt;

  public UserRegisterResponse(Long id, String name, String email, String role, LocalDateTime createdAt) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.role = role;
    this.createdAt = createdAt;
  }

  public Long getId() { return id; }
  public String getName() { return name; }
  public String getEmail() { return email; }
  public String getRole() { return role; }
  public LocalDateTime getCreatedAt() { return createdAt; }
}
