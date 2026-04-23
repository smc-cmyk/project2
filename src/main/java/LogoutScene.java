import javafx.fxml.FXML;

/*
 * Class for Logout Scene
 *
 * @author: Linda Nguyen
 * @since: 4/18/2026
 *
 */

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LogoutScene {
  //UI Strings
  private static final String logout = "Logout";
  static final String check = "Are you sure you want to logout?";
  private static final String yes = "Yes";
  private static final String no = "No";

  // Variables
  static Label logoutLabel;
  static Label checkLabel;
  static Button yesButton;
  static Button noButton;

  public static Scene create(Stage stage) {
    stage.setTitle("Log out");
    Database db = new Database();
    SceneFactory factory = new SceneFactory(db);

    // Initialization
    logoutLabel = new Label(logout);
    checkLabel = new Label(check);
    yesButton = new Button(yes);
    noButton = new Button(no);

    // Yes button takes you to the login scene
    yesButton.setOnAction(e -> {
      // Custom Dialog Box showing user logged out before going to the login screen
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("Logged Out");
      alert.setHeaderText(null);
      alert.setContentText("You're logged out.");
      alert.showAndWait();

      stage.setScene(factory.create(SceneType.LOGIN, stage));
    });

    // No button takes you to the main menu scene
    noButton.setOnAction(e -> {
      stage.setScene(factory.create(SceneType.MAIN_MENU, stage));
    });

    // Created the VBox
    VBox vBox = new VBox(10, logoutLabel, checkLabel, yesButton, noButton);
    vBox.setAlignment(Pos.CENTER);
    vBox.setSpacing(10);

    // Display the scene with dimensions
    Scene scene = new Scene(vBox, 500, 500);
    return scene;
  }
}