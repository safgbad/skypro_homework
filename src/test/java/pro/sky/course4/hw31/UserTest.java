package pro.sky.course4.hw31;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserTest {

  public final String DEFAULT_LOGIN = "pechenka123";
  public final String DEFAULT_EMAIL = "pechenka2012@email.ru";
  public final String ILLEGAL_EMAIL = "pechenka2012emailru";


  @Test
  public void shouldFillTheFieldsWithAllArgsConstructor() {
    User user = new User(DEFAULT_LOGIN, DEFAULT_EMAIL);

    assertEquals(DEFAULT_LOGIN, user.getLogin());
    assertEquals(DEFAULT_EMAIL, user.getEmail());
  }

  @Test
  public void shouldNotFillTheFieldsWithNoArgsConstructor() {
    User user = new User();

    assertNull(user.getLogin());
    assertNull(user.getEmail());
  }

  @Test
  public void shouldThrowIllegalArgumentExceptionWhenEmailHasNoRequiredSymbols() {
    assertThrows(IllegalArgumentException.class,
        () -> new User(DEFAULT_LOGIN, ILLEGAL_EMAIL));
  }

  @Test
  public void shouldThrowIllegalArgumentExceptionWhenLoginAndEmailAreEqual() {
    assertThrows(IllegalArgumentException.class,
        () -> new User(DEFAULT_EMAIL, DEFAULT_EMAIL));
  }
}
