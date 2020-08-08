package io.antonpegov.jwt.dao;

import io.antonpegov.jwt.model.User;

import java.util.List;
import java.util.UUID;

public interface UserDao {

  int insertUser(User user);

  List<User> selectAllUsers();

  User selectUserById(UUID id);

  User selectUserByEmail(String email);

  int updateUserById(UUID id, User user);

  int deleteUserById(UUID id);

}


