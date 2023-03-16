package pro.sky.course4.hw32.dao;

import pro.sky.course4.hw32.model.User;

import java.util.List;

public interface UserDao {

  User getUserByName(String name);

  List<User> findAllUsers();
}
