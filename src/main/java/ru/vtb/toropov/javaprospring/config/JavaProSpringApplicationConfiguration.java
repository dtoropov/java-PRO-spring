package ru.vtb.toropov.javaprospring.config;

import ru.vtb.toropov.javaprospring.dal.dao.UserDao;
import ru.vtb.toropov.javaprospring.service.UserService;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * JavaProSpringApplicationConfiguration.
 *
 * @author DToropov
 */
@Configuration
public class JavaProSpringApplicationConfiguration {

  @Value("jdbc:postgresql://localhost:5432/accdb")
  private String url;
  @Value("sa")
  private String userName;
  @Value("sa")
  private String password;

  @Bean
  public HikariConfig hikariConfig() {
    HikariConfig config = new HikariConfig();
    config.setJdbcUrl(url);
    config.setUsername(userName);
    config.setPassword(password);
    return config;
  }

  @Bean
  public HikariDataSource hikariDataSource() {
    return new HikariDataSource(hikariConfig());
  }

  @Bean
  public Connection connection() throws SQLException {
    return hikariDataSource().getConnection();
  }

  @Bean
  public UserDao userDao() throws SQLException {
    return new UserDao(connection());
  }

  @Bean
  public UserService userService() throws SQLException {
    return new UserService(userDao());
  }
}
