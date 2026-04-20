import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * Displays currency exchange rates along with their date of retrieval.
 *
 * @author Sean McFerran
 * @version 0.1.0
 * @since 04/14/2026
 */

public class CurrentExchangeRates {
    private static final String title = "Current Exchange Rates";
    private static final String timestamp = CurrencyConstants.dateOfRetrieval;
    private static Label headerLabel;
    private static Label dateLabel;
    private static Button returnButton;

    public static Scene create (Stage stage) {
        SceneFactory sceneFactory = new SceneFactory();

        headerLabel = new Label(title);
        dateLabel = new Label(timestamp);
        returnButton = new Button("Return to Main Menu");
    }
}
