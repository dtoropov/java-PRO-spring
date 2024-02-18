package ru.vtb.toropov.javaprospring;


import ru.vtb.toropov.javaprospring.config.JavaProSpringApplicationConfiguration;
import ru.vtb.toropov.javaprospring.dal.model.User;
import ru.vtb.toropov.javaprospring.service.UserService;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaProSpringApplication {

  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(
        JavaProSpringApplicationConfiguration.class);
    UserService userService = context.getBean(UserService.class);
    userService.deleteAll();
    userService.saveUser(new User(1L, "Иван"));
    userService.saveUser(new User(2L, "Пётр"));
    userService.saveUser(new User(3L, "Семён"));
    userService.editUser(new User(1L, "Николай"));
    userService.deleteUser(new User(1L, "Иван"));
    User user2 = userService.getUser(2L);
    System.out.println(user2);
    List<User> listUser = userService.getAllUser();
    System.out.println(listUser);
  }

}
