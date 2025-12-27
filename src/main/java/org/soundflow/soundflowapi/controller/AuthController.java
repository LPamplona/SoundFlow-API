package org.soundflow.soundflowapi.controller;


import jakarta.validation.Valid;
import org.soundflow.soundflowapi.dto.user.UserLoginRequest;
import org.soundflow.soundflowapi.dto.user.UserLoginResponse;
import org.soundflow.soundflowapi.dto.user.UserRegisterRequest;
import org.soundflow.soundflowapi.dto.user.UserRegisterResponse;
import org.soundflow.soundflowapi.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

  private final UserService userService;

  public AuthController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/register")
  public ResponseEntity<UserRegisterResponse> register (
      @Valid @RequestBody UserRegisterRequest request
  ) {
    UserRegisterResponse user = userService.createUser(request);

    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(user);
  }

  @PostMapping("/login")
  public ResponseEntity<UserLoginResponse> login (
      @Valid @RequestBody UserLoginRequest request
  ) {
    UserLoginResponse user = userService.login(request);

    return ResponseEntity
        .status(HttpStatus.OK)
        .body(user);
  }
}
