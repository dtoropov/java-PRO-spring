package ru.vtb.toropov.javaprospring.service;

import ru.vtb.toropov.javaprospring.dal.dao.UserDao;
import ru.vtb.toropov.javaprospring.dal.model.User;
import java.util.List;

/**
 * UserService.
 *
 * @author DToropov
 */
public class UserService {

  private final UserDao userDao;

  public UserService(UserDao userDao) {
    this.userDao = userDao;
  }

  public void saveUser(User user) {
    userDao.saveUser(user);
  }

  public void editUser(User user) {
    userDao.editUser(user);
  }

  public void deleteUser(User user) {
    userDao.deleteUser(user);
  }

  public void deleteAll() {
    userDao.deleteAll();
  }

  public User getUser(Long id) {
    return userDao.getUser(id);
  }

  public List<User> getAllUser() {
    return userDao.getAllUser();
  }

}
