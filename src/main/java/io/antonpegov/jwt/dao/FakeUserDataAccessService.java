package io.antonpegov.jwt.dao;

import io.antonpegov.jwt.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeDao")
public class FakeUserDataAccessService implements UserDao {

  //#region private
  private final static List<User> DB = new ArrayList<>();

  private User getById(UUID id) {
    return DB.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
  }

  private User getByEmail(String email) {
    return DB.stream().filter(u -> u.getEmail().equals(email)).findFirst().orElse(null);
  }

  private void add(User user) {
    DB.add(new User(user.getId(), user.getEmail(), user.getFirstName(), user.getLastName()));
  }

  private void remove(User user) {
    DB.remove(user);
  }
  //#endregion

  @Override
  public List<User> selectAllUsers() {
    return DB;
  }

  @Override
  public int insertUser(User user) {
    add(user);
    return 1;
  }

  @Override
  public User selectUserById(UUID id) {
    return getById(id);
  }

  @Override
  public User selectUserByEmail(String email) {
    return getByEmail(email);
  }

  @Override
  public int updateUserById(UUID id, User user) {
    remove(getById(id));
    add(user);
    return 1;
  }

  @Override
  public int deleteUserById(UUID id) {
    remove(getById(id));
    return 1;
  }
}
