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
  String register = "Register";
  String username = "Username";
  String password = "Password";
  String usernamePrompt = "Enter username";
  String passwordPrompt = "Enter password";
  TextField usernameInput = new TextField();
  TextField passwordInput = new TextField();

  static boolean validateLogin(Database db, String username, String password) {
    if (username == null || password == null) return false;

    username = username.trim();
    password = password.trim();

    if (username.isEmpty() || password.isEmpty()) return false;

    return db.checkUser(username, password);
  }

  static Scene buildLogin(Stage stage) {
    SceneFactory factory = new SceneFactory();
    Database db = new Database();
    stage.setTitle(title);
    Label usernameLabel = new Label(username);
    Label passwordLabel = new Label(password);
    Label messageLabel = new Label();
    TextField usernameInput = new TextField();
    TextField passwordInput = new TextField();
    usernameInput.setPromptText(usernamePrompt);
    passwordInput.setPromptText(passwordPrompt);
    Button enterButton = new Button(enter);
    Button registerButton = new Button(register);

    enterButton.setOnAction(e -> {
      String user = usernameInput.getText();
      String pw = passwordInput.getText();

      if (user.isEmpty() || pw.isEmpty()) {
        messageLabel.setText("Fields cannot be empty");
        return;
      }

      if (db.checkUser(user, pw)) {
        stage.setScene(factory.create(SceneType.MAIN_MENU, stage));
      } else {
        messageLabel.setText("Invalid login");
      }
    });

    registerButton.setOnAction(e -> {
      String user = usernameInput.getText().trim();
      String pw = passwordInput.getText().trim();

      if (user.isEmpty() || pw.isEmpty()) {
        messageLabel.setText("Input cannot be empty");
        return;
      }

      boolean success = db.createUser(user, pw); // must return boolean

      if (success) {
        messageLabel.setText("Registration successful.");
      } else {
        messageLabel.setText("Username already exists");
      }
    });

    VBox layout = new VBox(12,
        usernameLabel, usernameInput,
        passwordLabel, passwordInput,
        enterButton, registerButton,
        messageLabel
    );

    layout.setAlignment(Pos.CENTER);
    layout.setPadding(new Insets(30));

    Scene scene = new Scene(layout, SCENE_WIDTH, SCENE_HEIGHT);

    stage.setScene(scene);
    stage.show();

    return scene;
  }
}