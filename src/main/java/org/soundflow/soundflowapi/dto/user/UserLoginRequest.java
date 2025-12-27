package org.soundflow.soundflowapi.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserLoginRequest {

  @Email
  @NotBlank(message = "Email é obrigatório")
  private String email;

  @NotBlank(message = "Senha é obrigatória")
  private String password;

  public String getEmail() { return email; }

  public String getPassword() { return password; }
}
