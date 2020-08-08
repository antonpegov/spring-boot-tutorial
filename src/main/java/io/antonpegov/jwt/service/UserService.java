package io.antonpegov.jwt.service;

import io.antonpegov.jwt.dao.UserDao;
import io.antonpegov.jwt.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

  private final UserDao userDao;

  @Autowired
  public UserService(@Qualifier("fakeDao") UserDao userDao) {
    this.userDao = userDao;
  }

  public int addUser(User user) {
    UUID id = user.getId();
    String email = user.getEmail();

    if ((id != null && userDao.selectUserById(id) != null) || userDao.selectUserByEmail(email) != null) {
      System.out.println("Existed Email or User Id");
      return 0;
    }

    if (id == null) {
      return userDao.insertUser(new User(UUID.randomUUID(), email, user.getFirstName(), user.getLastName()));
    }

    return userDao.insertUser(user);
  }

  public List<User> getAllUsers() {
    return userDao.selectAllUsers();
  }

  public User getUserById(UUID id) {
    return userDao.selectUserById(id);
  }

  public int updateUserById(UUID id, User user) {
    if (!id.equals(user.getId()) || userDao.selectUserById(id) == null) {
      return 0;
    }
    return userDao.updateUserById(id, user);
  }

  public int deleteUserById(UUID id) {
    if (userDao.selectUserById(id) == null) {
      return 0;
    }
    return userDao.deleteUserById(id);
  }
}
