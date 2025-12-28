package org.soundflow.soundflowapi.controller;


import jakarta.validation.Valid;
import org.soundflow.soundflowapi.dto.jwt.JwtLoginResponse;
import org.soundflow.soundflowapi.dto.user.*;
import org.soundflow.soundflowapi.security.jwt.JwtUtils;
import org.soundflow.soundflowapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

  @Autowired
  private final UserService userService;

  @Autowired
  private final JwtUtils jwtUtils;

  public AuthController(UserService userService, JwtUtils jwtUtils) {
    this.userService = userService;
    this.jwtUtils = jwtUtils;
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
  public ResponseEntity<JwtLoginResponse> login (
      @Valid @RequestBody UserLoginRequest request
  ) {
    UserLoginResponse user = userService.login(request);

    String token = jwtUtils.generateJwtToken(user.getEmail(), user.getRole());

    JwtLoginResponse response = new JwtLoginResponse(
            token,
            user.getId(),
            user.getName(),
            user.getEmail(),
            user.getRole()
    );

    return ResponseEntity.status(HttpStatus.OK).body(response);
  }
}
