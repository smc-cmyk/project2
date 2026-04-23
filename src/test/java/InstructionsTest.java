/*
 * Instructions Unit test for Instructions Scene
 *
 * @author: Linda Nguyen
 * @since: 4/16/2026
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
import static org.junit.jupiter.api.Assertions.*;

class InstructionsTest {
    static Database db;

    @BeforeAll
    static void beforeAll() {
        Platform.startup(() -> {});

        db = new Database();
    }

    //Verify the back button is available
    @Test
    void testBackButton() throws Exception {
        final boolean[] exists = {false};

        Platform.runLater(() -> {
            Scene scene = MainMenu.buildMenu(new Stage());
            VBox root = (VBox) scene.getRoot();

            for (Node node : root.getChildren()) {
                if (node instanceof Button button &&
                    button.getText().equals("Return")) {
                    exists[0] = true;
                    break;
                }
            }

            assertTrue(exists[0]);
        });

        Thread.sleep(200);
    }
}