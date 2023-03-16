package pro.sky.course4.hw32.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.course4.hw32.dao.UserDao;
import pro.sky.course4.hw32.model.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

  @Mock
  private UserDao daoMock;

  @InjectMocks
  private UserService out;

  @Test
  public void checkUserExistsTest() {
    User existingUser = new User("Борис");
    User notExistingUser = new User("Богдан");
    when(daoMock.findAllUsers())
        .thenReturn(List.of(existingUser));

    assertTrue(out.checkUserExists(existingUser));
    assertFalse(out.checkUserExists(notExistingUser));
  }
}
