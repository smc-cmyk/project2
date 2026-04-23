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
import javafx.scene.text.Font;
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
    private static final String currTable = "\n" +
            "+-------------+------+--------+-------+------+------+\n" +
            "|      -      | Euro |  Yen   | Pound | Yuan | CAD  |\n" +
            "+-------------+------+--------+-------+------+------+\n" +
            "| 1 USD is..  | "+ CurrencyConstants.usdToEuro +" | "+ CurrencyConstants.usdToYen +" | "+ CurrencyConstants.usdToPound +" | "+ CurrencyConstants.usdToYuan +" | "+ CurrencyConstants.usdToCad +" |\n" +
            "+-------------+------+--------+-------+------+------+";
/*    //Object for Current Currency Conversion Rates
    private final SimpleStringProperty currency;
    private final SimpleDoubleProperty exchange;

    public CurrentExchangeRates(String curr, double exch) {
        this.currency = new SimpleStringProperty(curr);
        this.exchange = new SimpleDoubleProperty(exch);
    }
    public String getCurrency() {
        return currency.get();
    }
    public Double getExchange() {
        return  exchange.get();
    }*/

    /**
     *
     * Create a scene containing a TableView of historical exchange rates.
     * For USD to X Currency: CAD, Yen, Yuan, Pound, and Euro.
     * @return scene
     */
    public static Scene create (Stage stage) {
        Database db = new Database();
        SceneFactory SceneFactory = new SceneFactory(db);
        stage.setTitle(title);

        Label headerLabel = new Label(title);
        Label tableLabel = new Label(currTable);
        tableLabel.setFont(Font.font("Monospaced", 12));

        Button returnButton = new Button("Return");

        VBox root = new VBox(12, headerLabel, tableLabel, returnButton);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));

        Scene scene = new Scene(root);

        //Return to main menu
        returnButton.setOnAction(e -> {
            stage.setScene(SceneFactory.create(SceneType.MAIN_MENU,stage));
        });

/*        //Implement TableView of data
        //Create new TableView
        TableView<CurrentExchangeRates> currentExchange = new TableView<>();

        TableColumn<CurrentExchangeRates, String> currColumn = new TableColumn<>("Currency");
        currColumn.setCellValueFactory(new PropertyValueFactory<>("currency"));
        TableColumn<CurrentExchangeRates, String> exchangeColumn = new TableColumn<>("Exchange");
        exchangeColumn.setCellValueFactory(new PropertyValueFactory<>("exchange"));

        //Create observable list with usdToCurr variables
        ObservableList<CurrentExchangeRates> data = FXCollections.observableArrayList(
                new CurrentExchangeRates("EURO", CurrencyConstants.usdToEuro),
                new CurrentExchangeRates("CAD", CurrencyConstants.usdToCad),
                new CurrentExchangeRates("YEN", CurrencyConstants.usdToYen),
                new CurrentExchangeRates("POUND", CurrencyConstants.usdToPound),
                new CurrentExchangeRates("YUAN", CurrencyConstants.usdToYuan)
        );

        currentExchange.setItems(data);*/

        stage.setScene(scene);
        stage.show();

        return scene;
    }
}
