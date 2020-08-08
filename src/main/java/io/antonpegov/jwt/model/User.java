package io.antonpegov.jwt.model;

import java.util.UUID;

public class User {

  private final UUID id;
  private final String email;
  private final String firstName;
  private final String lastName;

  public User(UUID id, String email, String firstName, String lastName) {
    this.id = id;
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public UUID getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }
}
