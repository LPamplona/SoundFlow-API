package org.soundflow.soundflowapi.dto.user;

public class UserLoginResponse {
  private Long id;
  private String name;
  private String email;
  private String role;

  public Long getId() { return id; }
  public String getName() { return name; }
  public String getEmail() { return email; }
  public String getRole() { return role; }
}
