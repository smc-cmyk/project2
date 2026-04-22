import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

/**
 * Controller for providing a Return button
 *
 * @author Nettra Leandre
 * @version 0.1.0
 * @since 4/20/2026
 */
public class ReturnButton {
    @FXML
    private void handleReturn(javafx.event.ActionEvent event) {
      Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

      SceneFactory factory = new SceneFactory();
      stage.setScene(factory.create(SceneType.MAIN_MENU, stage));
    }
}
