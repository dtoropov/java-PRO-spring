package ru.vtb.toropov.javaprospring.dal.model;

/**
 * User.
 *
 * @author DToropov
 */
public class User {
  private Long id;
  private String userName;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public User(Long id, String userName) {
    this.id = id;
    this.userName = userName;
  }

  @Override
  public String toString()
  {
    return "id= "+ id + ", userName=" + userName;
  }
}
