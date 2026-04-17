/*
* Interface for Instructions Scene
*
* @author: Linda Nguyen
* @since: 4/16/2026
*
 */

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Instructions {

    public static Scene create(Stage stage) {
        Label title = new Label("Instructions");

        Label instructions = new Label(
                "Click on each button to navigate to desired scene \n" + "\n" +
                        "Enter desired USD amount to convert, then click desired currency to convert to \n" + "\n" +
                        "Click 'Return' to go to the previous scene" + "\n"
        );

        Button back = new Button("Return");

        back.setOnAction(e -> SceneFactory.switchScene(stage, SceneFactory.MAIN_MENU));

        VBox box = new VBox(20, title, instructions, back);
        box.setAlignment(Pos.CENTER);

        return new Scene(box, 500, 500);
    }
}