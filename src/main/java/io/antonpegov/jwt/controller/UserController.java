package io.antonpegov.jwt.controller;

import io.antonpegov.jwt.model.User;
import io.antonpegov.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Validated
@RestController()
@RequestMapping("/users")
public class UserController {

  @Autowired
  public UserService userService;

  @GetMapping
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }

  @GetMapping(path = "{id}")
  public User getUserById(@PathVariable("id") UUID id) {
    return userService.getUserById(id);
  }

  @PostMapping
  public int addUser(@RequestBody User user) {
    return userService.addUser(user);
  }

  @PutMapping(path = "{id}")
  public int updateUserById(@PathVariable("id") UUID id, @RequestBody User user) {
    return userService.updateUserById(id, user);
  }

  @DeleteMapping(path = "{id}")
  public int deleteUserById(@PathVariable("id") UUID id) {
    return userService.deleteUserById(id);
  }
}
