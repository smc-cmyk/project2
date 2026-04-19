import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Interface for Login scene
 *
 * @author Nettra Leandre
 * @version 0.1.0
 * @since 4/12/2026
 */

public interface Login {
  int SCENE_WIDTH = 400;
  int SCENE_HEIGHT = 300;
  String title = "Login";
  String enter = "Enter";
  String username = "Username";
  String password = "Password";
  String usernamePrompt = "Enter username";
  String passwordPrompt = "Enter password";
  TextField usernameInput = new TextField();
  TextField passwordInput = new TextField();

  static Scene buildLogin(Stage stage) {
    SceneFactory factory = new SceneFactory();
    stage.setTitle(title);

    Label usernameLabel = new Label(username);
    Label passwordLabel = new Label(password);
    usernameInput.setPromptText(usernamePrompt);
    usernameInput.setPrefWidth(200);
    passwordInput.setPromptText(passwordPrompt);
    passwordInput.setPrefWidth(200);
    Button enterButton = new Button(enter);

    VBox layout = new VBox(12, usernameLabel, usernameInput, passwordLabel,
        passwordInput, enterButton);
    layout.setAlignment(Pos.CENTER);
    layout.setPadding(new Insets(30));
    Scene scene = new Scene(layout, SCENE_WIDTH, SCENE_HEIGHT);

    enterButton.setOnAction(e ->
        stage.setScene(factory.create(SceneType.MAIN_MENU, stage))
    );

    stage.setScene(scene);
    stage.show();

    return scene;
  }
}