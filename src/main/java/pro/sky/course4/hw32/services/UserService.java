package pro.sky.course4.hw32.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sky.course4.hw32.dao.UserDao;
import pro.sky.course4.hw32.model.User;

@Service
public class UserService {

  private final UserDao dao;

  @Autowired
  public UserService(UserDao dao) {
    this.dao = dao;
  }

  public boolean checkUserExists(User user) {
    return dao.findAllUsers().contains(user);
  }
}
