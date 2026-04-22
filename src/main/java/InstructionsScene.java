/*
 * Interface for Instructions Scene
 *
 * @author: Linda Nguyen
 * @since: 4/18/2026
 *
 */

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InstructionsScene {
  // UI Strings
  private static final String title = "Instructions";
  private static final String instructions =
      "Click on each button to navigate to desired scene. \n\n" +
          "Enter desired USD amount to convert, then click desired currency to convert to. \n\n" +
          "Click 'Return' to go to the previous scene.";

  // Back button String
  private static final String back = "Return";

  private static Label titleLabel;
  private static Label instructionsLabel;
  private static Button backButton;

  public static Scene create(Stage stage) {

    SceneFactory factory = new SceneFactory();

    titleLabel = new Label(title);
    instructionsLabel = new Label(instructions);
    backButton = new Button(back);

    // Back button to go back to the Main Menu
    backButton.setOnAction(e -> {
      stage.setScene(factory.create(SceneType.MAIN_MENU, stage));
    });

    // Created the VBox
    VBox vBox = new VBox(10, titleLabel, instructionsLabel, backButton);
    vBox.setAlignment(Pos.CENTER);
    vBox.setSpacing(10);

    // Display the scene with dimensions
    Scene scene = new Scene(vBox, 590, 300);
    return scene;
  }

  public static Label getInstructionsLabel() {
    return instructionsLabel;
  }
  public static Button getBackButton() {
    return backButton;
  }
}