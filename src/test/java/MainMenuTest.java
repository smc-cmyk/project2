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
  static Database db;

  @BeforeAll
  static void startup() {
    Platform.startup(() -> {});

    db = new Database();
  }

  @Test
  void testConverter() throws Exception {
    final boolean[] exists = {false};

    Platform.runLater(() -> {
      Scene scene = MainMenu.buildMenu(new Stage());
      VBox root = (VBox) scene.getRoot();

      for (Node node : root.getChildren()) {
        if (node instanceof Button button &&
            button.getText().equals("USD Converter")) {
          exists[0] = true;
          break;
        }
      }

      assertTrue(exists[0]);
    });

    Thread.sleep(200);
  }

  @Test
  void testInstructions() throws Exception {
    final boolean[] exists = {false};

    Platform.runLater(() -> {
      Scene scene = MainMenu.buildMenu(new Stage());
      VBox root = (VBox) scene.getRoot();

      for (Node node : root.getChildren()) {
        if (node instanceof Button button &&
            button.getText().equals("Instructions")) {
          exists[0] = true;
          break;
        }
      }

      assertTrue(exists[0]);
    });

    Thread.sleep(200);
  }

  @Test
  void testRates() throws Exception {
    final boolean[] exists = {false};

    Platform.runLater(() -> {
      Scene scene = MainMenu.buildMenu(new Stage());
      VBox root = (VBox) scene.getRoot();

      for (Node node : root.getChildren()) {
        if (node instanceof Button button &&
            button.getText().equals("Exchange Rates")) {
          exists[0] = true;
          break;
        }
      }

      assertTrue(exists[0]);
    });

    Thread.sleep(200);
  }

  @Test
  void testRatesTable() throws Exception {
    final boolean[] exists = {false};

    Platform.runLater(() -> {
      Scene scene = MainMenu.buildMenu(new Stage());
      VBox root = (VBox) scene.getRoot();

      for (Node node : root.getChildren()) {
        if (node instanceof Button button &&
            button.getText().equals("Exchange Rates History (Table)")) {
          exists[0] = true;
          break;
        }
      }

      assertTrue(exists[0]);
    });

    Thread.sleep(200);
  }

  @Test
  void testRatesGraph() throws Exception {
    final boolean[] exists = {false};

    Platform.runLater(() -> {
      Scene scene = MainMenu.buildMenu(new Stage());
      VBox root = (VBox) scene.getRoot();

      for (Node node : root.getChildren()) {
        if (node instanceof Button button &&
            button.getText().equals("Exchange Rates History (Graph)")) {
          exists[0] = true;
          break;
        }
      }

      assertTrue(exists[0]);
    });

    Thread.sleep(200);
  }

  @Test
  void testLogout() throws Exception {
    final boolean[] exists = {false};

    Platform.runLater(() -> {
      Scene scene = MainMenu.buildMenu(new Stage());
      VBox root = (VBox) scene.getRoot();

      for (Node node : root.getChildren()) {
        if (node instanceof Button button &&
            button.getText().equals("Logout")) {
          exists[0] = true;
          break;
        }
      }

      assertTrue(exists[0]);
    });

    Thread.sleep(200);
  }
}
