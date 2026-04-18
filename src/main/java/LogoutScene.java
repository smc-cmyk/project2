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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LogoutScene {
    private static final String logout = "Logout";
    private static final String check = "Are you sure you want to logout?";
    private static final String yes = "Yes";
    private static final String no = "No";

    static Label logoutLabel;
    static Label checkLabel;
    static Button yesButton;
    static Button noButton;

    public Scene create(Stage stage) {
        logoutLabel = new Label(logout);
        checkLabel = new Label(check);
        yesButton = new Button(yes);
        noButton = new Button(no);

        yesButton.setOnAction(e -> {
            stage.setScene(SceneFactory.create(SceneType.LOGIN, stage));
        });

        noButton.setOnAction(e -> {
            stage.setScene(SceneFactory.create(SceneType.MAIN_MENU, stage));
        });

        VBox vBox = new VBox(10, logoutLabel, checkLabel, yesButton, noButton);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);

        Scene scene = new Scene(vBox, 500, 500);
        return scene;
}
}
