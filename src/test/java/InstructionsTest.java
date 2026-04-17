/*
 * Instructions Unit test for Instructions Scene
 *
 * @author: Linda Nguyen
 * @since: 4/16/2026
 *
 */

import javafx.application.Platform;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class InstructionsTest {

    @BeforeAll
    static void beforeAll() {
        Platform.startup(() -> {});
    }

    //Check for title to ensure information is flowing through
    @Test
    void testInstructions() {
        Instructions.create(new Stage());

        assertNotNull(Instructions.instructions);
        assertTrue(Instructions.instructions.getText().contains("Click"));
    }

    //Verify the back button is available
    @Test
    void testBackButton() {
        Instructions.create(new Stage());
        assertNotNull(Instructions.back);
        assertEquals("Back", Instructions.back.getText());
    }

}