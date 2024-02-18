package ru.vtb.toropov.javaprospring.dal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ru.vtb.toropov.javaprospring.dal.model.User;

/**
 * UserDao.
 *
 * @author DToropov
 */
public class UserDao {

  private final Connection connection;

  private static final String INS_USER =
      "insert into public.user(id, name) values(?, ?)";

  private static final String UPD_USER =
      "update public.user set name = ? where id = ?";

  private static final String DEL_USER =
      "delete from public.user where id = ?";

  private static final String DEL_ALL =
      "delete from public.user";

  private static final String SEL_USER =
      "select * from public.user where id =?";

  private static final String SEL_ALL =
      "select * from public.user";

  public UserDao(Connection connection) {
    this.connection = connection;
  }

  public void saveUser(User user) {
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(INS_USER);
      preparedStatement.setLong(1, user.getId());
      preparedStatement.setString(2, user.getUserName());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void editUser(User user) {
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(UPD_USER);
      preparedStatement.setString(1, user.getUserName());
      preparedStatement.setLong(2, user.getId());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void deleteUser(User user) {
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(DEL_USER);
      preparedStatement.setLong(1, user.getId());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void deleteAll() {
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(DEL_ALL);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public User getUser(Long id) {
    User user = null;
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(SEL_USER);
      preparedStatement.setLong(1, id);
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        user = new User(id, rs.getString("name"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return user;
  }

  public List<User> getAllUser() {
    List<User> listUser = new ArrayList<>();
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(SEL_ALL);
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        listUser.add(new User(rs.getLong("id"), rs.getString("name")));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return listUser;
  }

}
