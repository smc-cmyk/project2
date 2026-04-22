/*
 * Instructions Unit test for Instructions Scene
 *
 * @author: Linda Nguyen
 * @since: 4/18/2026
 *
 */

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


class InstructionsTest {

    @BeforeAll
    static void beforeAll() {
        Platform.startup(() -> {});
    }

    // Check for first word of instructions
    @Test
    void testInstructions() {
        InstructionsScene.create(new Stage());

        Label instructions = InstructionsScene.getInstructionsLabel();

        // Test to ensure instructions not null and has the text we are looking for
        assertNotNull(instructions);
        assertTrue(instructions.getText().contains("Click"));
    }

    // Verify the back button is available
    @Test
    void testBackButton() {
        InstructionsScene.create(new Stage());

        Button back = InstructionsScene.getBackButton();

        assertNotNull(back);
        assertEquals("Return", back.getText());
    }

}