import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
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

    //Object for Current Currency Conversion Rates
    //public void currToday(String curr, Double amount) {
        //this.curr =;
    //}
    public static Scene create (Stage stage) {
        SceneFactory factory = new SceneFactory();
        stage.setTitle(title + " - " + timestamp);

        headerLabel = new Label(title);
        dateLabel = new Label(timestamp);

        returnButton = new Button("Return to Main Menu");

        VBox root = new VBox(12, headerLabel, dateLabel, returnButton);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));

        Scene scene = new Scene(root);

        //Return to main menu
        returnButton.setOnAction(e -> {
            stage.setScene(factory.create(SceneType.MAIN_MENU,stage));
        });

        //TODO: Implement TableView of data
        TableView<Object> currentExchange = new TableView<>();

        ObservableList<Object> data = FXCollections.observableArrayList();

        TableColumn<Object, String> dateCol = new TableColumn<>("CURRENCY");
        dateCol.setCellValueFactory(new PropertyValueFactory<>("currency"));
        TableColumn<Object, String> exchangeRateCol = new TableColumn<>("1 USD TO FOREIGN CURRENCY");
        exchangeRateCol.setCellValueFactory(new PropertyValueFactory<>("exchangeRate"));
        currentExchange.getColumns().addAll(dateCol, exchangeRateCol);

        stage.setScene(scene);
        stage.show();

        return scene;
    }
}
