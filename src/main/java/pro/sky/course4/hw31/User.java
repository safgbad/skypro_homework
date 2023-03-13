package pro.sky.course4.hw31;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.regex.Pattern;

@NoArgsConstructor
@Getter
public class User {

  private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");

  private String login;
  private String email;

  public User(String login, String email) {
    if (!EMAIL_PATTERN.matcher(email).matches() || email.equals(login)) {
      throw new IllegalArgumentException();
    }

    this.login = login;
    this.email = email;
  }
}
