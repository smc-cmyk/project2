import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Login unit test for username and password values
 *
 * @author Nettra Leandre
 * @version 0.1.0
 * @since 4/13/2026
 */
class LoginTest {
  @Test
  void testCorrectLogin() {
    Login login = new Login();
    boolean isCorrect = Login.validateLogin("john", "123456");
    assertTrue(isCorrect);
  }

  @Test
  void testIncorrectUsername() {
    Login login = new Login();
    boolean isCorrect = Login.validateLogin(" ", "123456");
    assertFalse(isCorrect);
  }

  @Test
  void testIncorrectPassword() {
    Login login = new Login();
    boolean isCorrect = Login.validateLogin("john", " ");
    assertFalse(isCorrect);
  }
}
