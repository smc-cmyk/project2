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
 * Displays historical exchange rate data using a table view.
 *
 * @author Sean McFerran
 * @version 0.1.0
 * @since 04/14/2026
 */

public class HistoryTableScene{
    private static final String title = "Current Exchange Rates at " + CurrencyConstants.dateOfRetrieval;
    //Object for Current Currency Conversion Rates
    private final SimpleStringProperty currency;
    private final SimpleDoubleProperty exchange1970;
    private final SimpleDoubleProperty exchange1980;
    private final SimpleDoubleProperty exchange1990;
    private final SimpleDoubleProperty exchange2000;
    private final SimpleDoubleProperty exchange2010;
    private final SimpleDoubleProperty exchange2020;
    private final SimpleDoubleProperty exchange2026;

    private HistoryTableScene(String curr, double ex1970, double ex1980, double ex1990, double ex2000, double ex2010, double ex2020, double ex2026) {
        this.currency = new SimpleStringProperty(curr);
        this.exchange1970 = new SimpleDoubleProperty(ex1970);
        this.exchange1980 = new SimpleDoubleProperty(ex1980);
        this.exchange1990 = new SimpleDoubleProperty(ex1990);
        this.exchange2000 = new SimpleDoubleProperty(ex2000);
        this.exchange2010 = new SimpleDoubleProperty(ex2010);
        this.exchange2020 = new SimpleDoubleProperty(ex2020);
        this.exchange2026 = new SimpleDoubleProperty(ex2026);
    }
    public String getCurrency() {
        return currency.get();
    }

    public double getExchange1970() {
        return exchange1970.get();
    }


    public double getExchange1980() {
        return exchange1980.get();
    }


    public double getExchange1990() {
        return exchange1990.get();
    }


    public double getExchange2000() {
        return exchange2000.get();
    }


    public double getExchange2010() {
        return exchange2010.get();
    }


    public double getExchange2020() {
        return exchange2020.get();
    }


    public double getExchange2026() {
        return exchange2026.get();
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
        TableView<HistoryTableScene> table = new TableView<>();
        //Create observable list with usdToCurr variables
        final ObservableList<HistoryTableScene> data = FXCollections.observableArrayList(
                new HistoryTableScene("EURO",0.0, 0.0, 0.0, 1.086, 0.755, 0.877, CurrencyConstants.usdToEuro),
                new HistoryTableScene("YEN", 360.0, 226.63, 125.0, 108.8, 87.77, 106.75, CurrencyConstants.usdToYen),
                new HistoryTableScene("POUND", 0.417, 0.43, 0.56, 0.66, 0.648, 0.78, CurrencyConstants.usdToPound),
                new HistoryTableScene("YUAN", 2.46, 1.5, 4.78, 8.279, 6.77, 6.9, CurrencyConstants.usdToYuan),
                new HistoryTableScene("CAD", 1.044, 1.169, 1.167, 1.486, 1.03, 1.342, CurrencyConstants.usdToCad)
        );

        stage.setTitle(title);

        Label headerLabel = new Label(title);

        Button returnButton = new Button("Return");

        VBox root = new VBox(12, headerLabel, table, returnButton);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));

        Scene scene = new Scene(root);

        //Return to main menu
        returnButton.setOnAction(e -> {
            stage.setScene(SceneFactory.create(SceneType.MAIN_MENU,stage));
        });

        //Implement TableView of data
        TableColumn exchangeCol = new TableColumn("1 USD is...");
        exchangeCol.setCellValueFactory(new PropertyValueFactory<HistoryTableScene, String>("currency"));
        TableColumn col1970 = new TableColumn("1970");
        col1970.setCellValueFactory(new PropertyValueFactory<HistoryTableScene, String>("exchange1970"));
        TableColumn col1980 = new TableColumn("1980");
        col1980.setCellValueFactory(new PropertyValueFactory<HistoryTableScene, String>("exchange1980"));
        TableColumn col1990 = new TableColumn("1990");
        col1990.setCellValueFactory(new PropertyValueFactory<HistoryTableScene, String>("exchange1990"));
        TableColumn col2000 = new TableColumn("2000");
        col2000.setCellValueFactory(new PropertyValueFactory<HistoryTableScene, String>("exchange2000"));
        TableColumn col2010 = new TableColumn("2010");
        col2010.setCellValueFactory(new PropertyValueFactory<HistoryTableScene, String>("exchange2010"));
        TableColumn col2020 = new TableColumn("2020");
        col2020.setCellValueFactory(new PropertyValueFactory<HistoryTableScene, String>("exchange2020"));
        TableColumn col2026 = new TableColumn("2026");
        col2026.setCellValueFactory(new PropertyValueFactory<HistoryTableScene, String>("exchange2026"));


        table.setItems(data);
        table.getColumns().addAll(exchangeCol, col1970, col1980, col1990, col2000, col2010, col2020, col2026);

        stage.setScene(scene);
        stage.show();

        return scene;
    }
}
