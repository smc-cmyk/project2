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
  static Database db;

  @BeforeAll
  static void startup() {
    Platform.startup(() -> {});

    db = new Database();
    db.createUser("john", "123456");
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
  void testRegister() {
    Scene scene = Login.buildLogin(new Stage());
    VBox root = (VBox) scene.getRoot();

    boolean exists = false;

    for (Node node : root.getChildren()) {
      if (node instanceof Button button) {
        if (button.getText().equals("Register")) {
          exists = true;
          break;
        }
      }
    }

    assertTrue(exists);
  }

  @Test
  void testCorrectLogin() {
    assertTrue(db.checkUser("john", "123456"));
  }

  @Test
  void testIncorrectUsername() {
    assertFalse(db.checkUser("j", "123456"));
  }

  @Test
  void testIncorrectPassword() {
    assertFalse(db.checkUser("john", "1"));
  }
}
