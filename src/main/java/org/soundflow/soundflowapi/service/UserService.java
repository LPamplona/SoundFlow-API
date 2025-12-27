package org.soundflow.soundflowapi.service;

import org.soundflow.soundflowapi.dto.user.UserLoginRequest;
import org.soundflow.soundflowapi.dto.user.UserLoginResponse;
import org.soundflow.soundflowapi.dto.user.UserRegisterRequest;
import org.soundflow.soundflowapi.dto.user.UserRegisterResponse;
import org.soundflow.soundflowapi.entity.UserEntity;
import org.soundflow.soundflowapi.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public UserService(UserRepository userRepository,
                     PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public UserRegisterResponse createUser(UserRegisterRequest request) {

    // Criptografa a senha
    String encodedPassword = passwordEncoder.encode(request.getPassword());

    // Cria a entidade via factory method (CORRETO)
    UserEntity user = UserEntity.create(
        request.getName(),
        request.getEmail(),
        encodedPassword,
        "USER"
    );

    // Persiste
    UserEntity savedUser = userRepository.save(user);

    // Retorna DTO (NUNCA a entity)
    return new UserRegisterResponse(
        savedUser.getId(),
        savedUser.getName(),
        savedUser.getEmail(),
        savedUser.getRole(),
        savedUser.getCreatedAt()
    );
  }

  public UserLoginResponse login(UserLoginRequest request) {

    passwordEncoder.matches(rawPassword, encodedPassword);
  }
}
