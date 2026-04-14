
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for historic table scene.
 *
 * @author Sean McFerran
 * @version 0.1.0
 * @since 04/14/2026
 */

class HistoricTableSceneTest {

    @BeforeEach
    void setUp() {
        historicTable = new historicTable();
    }

    @Test
    @DisplayName("New tableview is empty")
    void newTableviewIsEmpty() {
        assertTrue(historicTable.isEmpty());
        assertEquals(0, historicTable.getRows());
    }

    @Test
    @DisplayName("TableView contains correct amount of rows")
    void testTableRowAmounts() {
        assertEquals(historicTable.getRows().size(), 8);
    }

    @Test
    @DisplayName("TableView contains correct amount of columns")
    void testTableColumnAmounts() {
        assertEquals(historicTable.getColumns().size(), 6);
    }

}