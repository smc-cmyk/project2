import javafx.application.Platform;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Main Menu unit test for buttons
 *
 * @author Nettra Leandre
 * @version 0.1.0
 * @since 4/17/2026
 */
public class MainMenuTest {
  @BeforeAll
  static void startup() {
    Platform.startup(() -> {});
  }

  @Test
  void testConverter() {
    Scene scene = MainMenu.buildMenu(new Stage());
    VBox root = (VBox) scene.getRoot();
    boolean exists = false;

    for (Node node : root.getChildren()) {
      if (node instanceof Button button) {
        if (button.getText().equals("USD Converter")) {
          exists = true;
          break;
        }
      }
    }

    assertTrue(exists);
  }

  @Test
  void testInstructions() {
    Scene scene = MainMenu.buildMenu(new Stage());
    VBox root = (VBox) scene.getRoot();
    boolean exists = false;

    for (Node node : root.getChildren()) {
      if (node instanceof Button button) {
        if (button.getText().equals("Instructions")) {
          exists = true;
          break;
        }
      }
    }

    assertTrue(exists);
  }

  @Test
  void testRates() {
    Scene scene = MainMenu.buildMenu(new Stage());
    VBox root = (VBox) scene.getRoot();
    boolean exists = false;

    for (Node node : root.getChildren()) {
      if (node instanceof Button button) {
        if (button.getText().equals("Exchange Rates")) {
          exists = true;
          break;
        }
      }
    }

    assertTrue(exists);
  }

  @Test
  void testRatesTable() {
    Scene scene = MainMenu.buildMenu(new Stage());
    VBox root = (VBox) scene.getRoot();
    boolean exists = false;

    for (Node node : root.getChildren()) {
      if (node instanceof Button button) {
        if (button.getText().equals("Exchange Rates History (Table)")) {
          exists = true;
          break;
        }
      }
    }

    assertTrue(exists);
  }

  @Test
  void testRatesGraph() {
    Scene scene = MainMenu.buildMenu(new Stage());
    VBox root = (VBox) scene.getRoot();
    boolean exists = false;

    for (Node node : root.getChildren()) {
      if (node instanceof Button button) {
        if (button.getText().equals("Exchange Rates History (Graph)")) {
          exists = true;
          break;
        }
      }
    }

    assertTrue(exists);
  }

  @Test
  void testLogout() {
    Scene scene = MainMenu.buildMenu(new Stage());
    VBox root = (VBox) scene.getRoot();
    boolean exists = false;

    for (Node node : root.getChildren()) {
      if (node instanceof Button button) {
        if (button.getText().equals("Logout")) {
          exists = true;
          break;
        }
      }
    }

    assertTrue(exists);
  }
}
