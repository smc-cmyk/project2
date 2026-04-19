/*
 * Instructions Unit test for Logout Scene
 *
 * @author: Linda Nguyen
 * @since: 4/18/2026
 *
 */

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LogoutTest {
    private Stage stage;
    private LogoutScene logout;

    @BeforeAll
    static void beforeAll() {
        Platform.startup(() -> {});
    }

    // Check if the logout scene works looking for the expected text
    @Test
    void testLogout() {
        stage = new Stage();
        logout = new LogoutScene();

        Scene scene = logout.create(stage);
        stage.setScene(scene);
        stage.show();

        assertNotNull(stage.getScene());
        assertEquals("Are you sure you want to logout?", LogoutScene.checkLabel.getText());
    }
}
