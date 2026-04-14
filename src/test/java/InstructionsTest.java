/*
 * Instructions Unit test for Instructions Scene
 *
 * @author: Linda Nguyen
 * @since: 4/14/2026
 *
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.unit.List;


class InstructionsTest {

    //Check for title to ensure information is flowing through
    @Test
    void testInstructions() {
        Instructions instruction = new Instructions();
        assertEquals("Instructions", title.getText());
    }

    //Verify the back button is available
    @Test
    void testBackButton() {
        Instructions instructions = new Instructions();
        assertEquals("Back", backButton.getText());
    }

}