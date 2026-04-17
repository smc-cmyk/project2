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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Instructions {

    public static Label instructions;
    public static Button back;

    public static Scene create(Stage stage) {

        //Title of the scene
        Label title = new Label("Instructions");

        //Text of instructions
        instructions = new Label(
                "Click on each button to navigate to desired scene \n" + "\n" +
                        "Enter desired USD amount to convert, then click desired currency to convert to \n" + "\n" +
                        "Click 'Return' to go to the previous scene" + "\n"
        );

        //Back button
        back = new Button("Return");

        //Back button to go back to the main menu
        back.setOnAction(e -> SceneFactory.switchScene(stage, SceneFactory.MAIN_MENU));

        //Spacing and content
        VBox box = new VBox(10, title, instructions, back);
        box.setAlignment(Pos.CENTER);

        //Returns the scene with width and height
        return new Scene(box, 500, 500);
    }
}