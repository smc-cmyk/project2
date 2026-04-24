import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import static org.junit.jupiter.api.Assertions.*;
/**
 * [Unit test for USDConverterResults Scene]
 *
 * @author Kevin Pena Alvarez
 * @version 0.1.0
 * @since 4/23/26
 **/
class USDConverterResultsTest {
    @BeforeAll
    static void initFX() {
        Platform.startup(() -> {});
    }

    @Test
    void convert() throws Exception {
        setResult("");
        getHistory().clear();

        USDConverterResults.convert(10.0, 2.0, "CAD");

        assertEquals("10.00 USD = 20.00 CAD", getResult());
        assertTrue(getHistory().isEmpty());

        USDConverterResults.convert(5.0, 2.0, "EUR");

        assertEquals("5.00 USD = 10.00 EUR", getResult());
        assertEquals(1, getHistory().size());
        assertEquals("10.00 USD = 20.00 CAD", getHistory().get(0));
    }

    @Test
    void create() throws Exception {
        setResult("");
        getHistory().clear();
        USDConverterResults.convert(10.0, 1.5, "CAD");

        CountDownLatch latch = new CountDownLatch(1);
        final Scene[] sceneHolder = new Scene[1];
        final Stage[] stageHolder = new Stage[1];
        final Throwable[] errorHolder = new Throwable[1];

        Platform.runLater(() -> {
            try {
                Stage stage = new Stage();
                Scene scene = USDConverterResults.create(stage);

                stageHolder[0] = stage;
                sceneHolder[0] = scene;
            } catch (Throwable e) {
                errorHolder[0] = e;
            } finally {
                latch.countDown();
            }
        });

        latch.await();

        if (errorHolder[0] != null) {
            throw new RuntimeException(errorHolder[0]);
        }

        assertNotNull(sceneHolder[0]);
        assertEquals("USD Converter Results", stageHolder[0].getTitle());
        assertEquals(400, sceneHolder[0].getWidth());
        assertEquals(300, sceneHolder[0].getHeight());
    }

    private String getResult() throws Exception {
        Field field = USDConverterResults.class.getDeclaredField("result");
        field.setAccessible(true);
        return (String) field.get(null);
    }

    private void setResult(String value) throws Exception {
        Field field = USDConverterResults.class.getDeclaredField("result");
        field.setAccessible(true);
        field.set(null, value);
    }

    @SuppressWarnings("unchecked")
    private List<String> getHistory() throws Exception {
        Field field = USDConverterResults.class.getDeclaredField("history");
        field.setAccessible(true);
        return (List<String>) field.get(null);
    }
}