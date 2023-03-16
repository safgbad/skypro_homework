package pro.sky.course4.hw32.dao.impl;

import org.springframework.stereotype.Component;
import pro.sky.course4.hw32.dao.UserDao;
import pro.sky.course4.hw32.model.User;

import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

  private static List<User> users;

  public UserDaoImpl() {
    users = List.of( // не знаю почему здесь, а не в тесте, но ТЗ таково
        new User("Виталий"),
        new User("Виктория"),
        new User("Виолетта"),
        new User("Виктор"),
        new User("Вячеслав"),
        new User("Владимир"));
  }

  @Override
  public User getUserByName(String name) {
    return users.stream()
        .filter(user -> user.getName().equals(name))
        .findFirst().orElse(null);
  }

  @Override
  public List<User> findAllUsers() {
    return users;
  }
}
