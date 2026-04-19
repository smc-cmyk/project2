import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Login unit test for username/password values and enter button
 *
 * @author Nettra Leandre
 * @version 0.1.0
 * @since 4/13/2026
 */
class LoginTest {
  @BeforeAll
  static void startup() {
    Platform.startup(() -> {});
  }

  @Test
  void testEnter() {
    Scene scene = Login.buildLogin(new Stage());
    VBox root = (VBox) scene.getRoot();
    boolean exists = false;

    for (Node node : root.getChildren()) {
      if (node instanceof Button button) {
        if (button.getText().equals("Enter")) {
          exists = true;
          break;
        }
      }
    }

    assertTrue(exists);
  }

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
