import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * [Description]
 *
 * @author Kevin Pena Alvarez
 * @version 0.1.0
 * @since 4/14/26
 **/
class DatabaseTest {
    private Database db;

    @BeforeEach
    void setUp() {
        db = new Database();
    }

    @AfterEach
    void tearDown() {
        if (db != null) {
            db.close();
        }
    }

    @Test
    void close() {
        db.close();
        assertTrue(true);
    }

    @Test
    void createUser() {
        db.createUser("Kevin23", "1997");
        boolean exists = db.checkUser("Kevin23", "1997");
        assertTrue(exists);
    }

    @Test
    void checkUser_Valid() {
        db.createUser("Kevin25", "1997");
        boolean result = db.checkUser("Kevin25","1997");
        assertTrue(result);
    }

    @Test
    void checkUser_invalidPassword() {
        db.createUser("Kevin25", "1997");
        boolean result = db.checkUser("Kevin25","1990");
        assertFalse(result);
    }

    @Test
    void checkUser_userDoesntExist() {
        boolean result = db.checkUser("Kevin", "1997");
        assertFalse(result);
    }

    @Test
    void getAllItems() {
        db.insertItem("Car");
        db.insertItem("Car2");

        var items = db.getAllItems();

        assertTrue(items.contains("Car"));
        assertTrue(items.contains("Car2"));
    }

    @Test
    void markDone() {

    }

    @Test
    void deleteItem() {
        db.clearItems();
        db.insertItem("needs to be deleted");

        var itemsB4 = db.getAllItems();
        assertTrue(itemsB4.contains("needs to be deleted"));

        int id = itemsB4.size();

        db.deleteItem(id);

        var itemsAfter = db.getAllItems();
        assertFalse(itemsAfter.contains("needs to be deleted"));
    }

    @Test
    void insertItem() {
        db.clearItems();

        db.insertItem("new item");

        var items = db.getAllItems();
        assertTrue(items.contains("new item"));
    }
}