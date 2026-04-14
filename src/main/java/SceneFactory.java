import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * [Description]
 *
 * @author Kevin Pena Alvarez
 * @version 0.1.0
 * @since 4/14/26
 **/
public class SceneFactory {
    public static final int LOGIN = 1;
    public static final int MAIN_MENU = 2;
    public static final int HISTORIC_TABLE = 3;
    public static final int HISTORIC_GRAPH = 4;
    public static final int REAL_TIME = 5;
    public static final int CONVERTER_MENU = 6;
    public static final int CONVERTER_RESULTS = 7;
    public static final int INSTRUCTIONS = 8;
    public static final int LOGOUT = 9;

    //this is the method that switches the scene
    public static void switchScene(Stage stage, int sceneId) {
        Scene scene = getScene(sceneId, stage); //retrieves scenes
        stage.setScene(scene);
    }

    //Scenes still need to be made
    private static Scene getScene(int sceneId, Stage stage) {
        return switch (sceneId) {
            case LOGIN -> LoginScene.create(stage);
            case MAIN_MENU -> MainMenuScene.create(stage);
            case HISTORIC_TABLE -> HistoricTableScene.create(stage);
            case HISTORIC_GRAPH -> GraphScene.create(stage);
            case REAL_TIME -> RealtimeScene.create(stage);
            case CONVERTER_MENU -> ConvertScene.create(stage);
            case CONVERTER_RESULTS -> ResultScene.create(stage);
            case INSTRUCTIONS -> InstructionsScene.create(stage);
            case LOGOUT -> LogoutScene.create(stage);
            default -> throw new IllegalArgumentException("Invalid scene");
        };
    }
}




