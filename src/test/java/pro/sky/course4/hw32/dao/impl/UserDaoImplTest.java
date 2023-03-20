package pro.sky.course4.hw32.dao.impl;

import org.junit.jupiter.api.Test;
import pro.sky.course4.hw32.model.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class UserDaoImplTest {

  private final UserDaoImpl out = new UserDaoImpl();

  @Test
  public void getUserByNameShouldReturnCorrectUserWhenExists() {
    User user = new User("Виолетта");
    User foundUser = out.getUserByName(user.getName());

    assertEquals(user, foundUser);
  }

  @Test
  public void getUserByNameShouldReturnNullWhenUserDoesNotExist() {
    User user = out.getUserByName("Марк");

    assertNull(user);
  }
}
