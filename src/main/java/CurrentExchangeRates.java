import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
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
    private static final String title = "Current Exchange Rates at " + CurrencyConstants.dateOfRetrieval;
    //Object for Current Currency Conversion Rates
    private final SimpleStringProperty currency;
    private final SimpleDoubleProperty exchange;

    private CurrentExchangeRates(String curr, double exch) {
        this.currency = new SimpleStringProperty(curr);
        this.exchange = new SimpleDoubleProperty(exch);
    }
    public String getCurrency() {
        return currency.get();
    }
    public Double getExchange() {
        return  exchange.get();
    }

    /**
     *
     * Create a scene containing a TableView of historical exchange rates.
     * For USD to X Currency: CAD, Yen, Yuan, Pound, and Euro.
     * @return scene
     */
    public static Scene create (Stage stage) {
        Database db = new Database();
        SceneFactory SceneFactory = new SceneFactory(db);

        //Create new TableView
        TableView<CurrentExchangeRates> currentExchange = new TableView<>();
        //Create observable list with usdToCurr variables
        final ObservableList<CurrentExchangeRates> data = FXCollections.observableArrayList(
                new CurrentExchangeRates("EURO", CurrencyConstants.usdToEuro),
                new CurrentExchangeRates("CAD", CurrencyConstants.usdToCad),
                new CurrentExchangeRates("YEN", CurrencyConstants.usdToYen),
                new CurrentExchangeRates("POUND", CurrencyConstants.usdToPound),
                new CurrentExchangeRates("YUAN", CurrencyConstants.usdToYuan)
        );

        stage.setTitle(title);

        Label headerLabel = new Label(title);

        Button returnButton = new Button("Return");

        VBox root = new VBox(12, headerLabel, currentExchange, returnButton);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));

        Scene scene = new Scene(root);

        //Return to main menu
        returnButton.setOnAction(e -> {
            stage.setScene(SceneFactory.create(SceneType.MAIN_MENU,stage));
        });

        //Implement TableView of data
        TableColumn exchangeCol = new TableColumn("1 USD is...");
        exchangeCol.setCellValueFactory(new PropertyValueFactory<CurrentExchangeRates, String>("exchange"));
        TableColumn currCol = new TableColumn("");
        currCol.setCellValueFactory(new PropertyValueFactory<CurrentExchangeRates, String>("currency"));

        currentExchange.setItems(data);
        currentExchange.getColumns().addAll(exchangeCol, currCol);

        stage.setScene(scene);
        stage.show();

        return scene;
    }
}
