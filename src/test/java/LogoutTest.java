/*
 * Instructions Unit test for Logout Scene
 *
 * @author: Linda Nguyen
 * @since: 4/18/2026
 *
 */

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogoutTest {
    private Stage stage;
    private LogoutScene logout;

    @BeforeAll
    static void beforeAll() {
        Platform.startup(() -> {});
    }

    @Test
    void testYesButton() throws Exception {
        final boolean[] exists = {false};

        Platform.runLater(() -> {
            Scene scene = MainMenu.buildMenu(new Stage());
            VBox root = (VBox) scene.getRoot();

            for (Node node : root.getChildren()) {
                if (node instanceof Button button &&
                    button.getText().equals("Yes")) {
                    exists[0] = true;
                    break;
                }
            }

            assertTrue(exists[0]);
        });

        Thread.sleep(200);
    }

    @Test
    void testNoButton() throws Exception {
        final boolean[] exists = {false};

        Platform.runLater(() -> {
            Scene scene = MainMenu.buildMenu(new Stage());
            VBox root = (VBox) scene.getRoot();

            for (Node node : root.getChildren()) {
                if (node instanceof Button button &&
                    button.getText().equals("No")) {
                    exists[0] = true;
                    break;
                }
            }

            assertTrue(exists[0]);
        });

        Thread.sleep(200);
    }
}
