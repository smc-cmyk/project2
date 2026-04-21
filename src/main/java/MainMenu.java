import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Main Menu class providing button navigation to other scenes
 *
 * @author Nettra Leandre
 * @version 0.1.0
 * @since 4/17/2026
 */
public class MainMenu {
  static int SCENE_WIDTH = 400;
  static int SCENE_HEIGHT = 300;
  static String label = "Main Menu";
  static String converter = "USD Converter";
  static String instructions = "Instructions";
  static String rates = "Exchange Rates";
  static String ratesTable = "Exchange Rates History (Table)";
  static String ratesGraph = "Exchange Rates History (Graph)";
  static String logout = "Logout";

  static Scene buildMenu(Stage stage) {
    Database db = new Database();
    SceneFactory factory = new SceneFactory(db);
    stage.setTitle(label);

    Button converterButton = new Button(converter);
    Button instructionsButton = new Button(instructions);
    Button ratesButton = new Button(rates);
    Button ratesTableButton = new Button(ratesTable);
    Button ratesGraphButton = new Button(ratesGraph);
    Button logoutButton = new Button(logout);

    VBox layout = new VBox(12, converterButton, instructionsButton,
        ratesButton, ratesTableButton, ratesGraphButton, logoutButton);
    layout.setAlignment(Pos.CENTER);
    layout.setPadding(new Insets(30));
    Scene scene = new Scene(layout, SCENE_WIDTH, SCENE_HEIGHT);

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

    stage.setScene(scene);
    stage.show();

    return scene;
  }
}
