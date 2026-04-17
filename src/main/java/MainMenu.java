import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Main Menu class providing button navigation to other scenes
 *
 * @author Nettra Leandre
 * @version 0.1.0
 * @since 4/17/2026
 */
public interface MainMenu {
  String label = "Main Menu";
  String converter = "USD Converter";
  String instructions = "Instructions";
  String rates = "Exchange Rates";
  String ratesTable = "Exchange Rates History (Table)";
  String ratesGraph = "Exchange Rates History (Graph)";
  String logout = "Logout";

  static Scene buildMenu(Stage stage) {
    SceneFactory factory = new SceneFactory();

    Label menuLabel = new Label(label);
    Button converterButton = new Button(converter);
    Button instructionsButton = new Button(instructions);
    Button ratesButton = new Button(rates);
    Button ratesTableButton = new Button(ratesTable);
    Button ratesGraphButton = new Button(ratesGraph);
    Button logoutButton = new Button(logout);

    converterButton.setOnAction(e ->
        stage.setScene(factory.create(SceneType.US_TO_, stage))
    );

    instructionsButton.setOnAction(e ->
        stage.setScene(factory.create(SceneType.INSTRUCTIONS, stage))
    );

    ratesButton.setOnAction(e ->
        stage.setScene(factory.create(SceneType.EXCHANGE_RATE_HISTORY, stage))
    );

    ratesTableButton.setOnAction(e ->
        stage.setScene(factory.create(SceneType.TABLE_OF_EXCHANGE_RATE_HISTORY, stage))
    );

    ratesGraphButton.setOnAction(e ->
        stage.setScene(factory.create(SceneType.GRAPH_OF_EXCHANGE_RATE_HISTORY, stage))
    );

    logoutButton.setOnAction(e ->
        stage.setScene(factory.create(SceneType.LOGOUT, stage))
    );

    VBox layout = new VBox(10, menuLabel, converterButton, instructionsButton,
        ratesButton, ratesTableButton, ratesGraphButton, logoutButton);

    layout.setAlignment(Pos.CENTER);

    return new Scene(layout, 400, 400);
  }
}
