import java.util.Objects;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 * [This is the Scene for conversion from USD to supported currencies. ]
 *
 * @author Kevin Pena Alvarez
 * @version 0.1.0
 * @since 4/15/26
 **/
public class UStoScene {
    public static Scene create(Stage stage) {
        stage.setTitle("USD Converter");

        try {
            Parent root = FXMLLoader.load(
                    Objects.requireNonNull(
                            UStoScene.class.getResource("/UStoScene.fxml")
                    )
            );

            return new Scene(root, 400, 300);

        } catch (Exception e) {
            e.printStackTrace();
            return new Scene(new Label("Error loading scene"), 400, 350);
        }
    }
}