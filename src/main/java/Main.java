
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Class calls SceneFactory to create scene
 *
 * @author Nettra Leandre
 * @version 0.1.0
 * @since 3/25/26
 */
public class Main extends Application {

  /**
   * Called by the JavaFX runtime after the application is initialized.
   * Build your scene graph here and show the primary Stage (window).
   *
   * @param stage the primary window provided by the JavaFX runtime
   */
  @Override
  public void start(Stage stage) {
    Database db = new Database();
    SceneFactory factory = new SceneFactory(db);
    stage.setScene(factory.create(SceneType.LOGIN, stage));
    stage.setTitle("Login");
    stage.show();
  }

  /**
   * Application entry point. JavaFX requires calling launch(), which
   * internally creates the JavaFX runtime and calls start().
   */
  public static void main(String[] args) {
    launch(args);
  }
}