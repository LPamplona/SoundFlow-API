package org.soundflow.soundflowapi.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  private String role;

  @Column(name = "created_at", nullable = false)
  private LocalDateTime createdAt;

  // Obrigatório para JPA
  protected UserEntity() {}

  // Construtor real fica privado
  private UserEntity(String name, String email, String password, String role) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.role = role;
    this.createdAt = LocalDateTime.now();
  }

  // Factory method
  public static UserEntity create(String name, String email, String password, String role) {
    return new UserEntity(name, email, password, role);
  }

  // getters...

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public String getRole() {
    return role;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }
}
