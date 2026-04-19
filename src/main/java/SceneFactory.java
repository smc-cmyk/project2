import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * SceneFactory for switching between scenes
 *
 * @author Kevin Pena Alvarez
 * @version 0.1.0
 * @since 4/14/26
 **/
public class SceneFactory {

    public Scene create (SceneType sceneType, Stage stage) {
        switch(sceneType) {
           case LOGIN:
                return Login.buildLogin(stage);
            case MAIN_MENU:
                return MainMenu.buildMenu(stage);
//            case EXCHANGE_RATE_HISTORY:
//                return ExchangeRateHistoryScene.create(stage);
//            case TABLE_OF_EXCHANGE_RATE_HISTORY:
//                return TableOfExchangeHistoryScene.create(stage);
//            case GRAPH_OF_EXCHANGE_RATE_HISTORY:
//                return GraphOfExchangeHistoryScene.create(stage);
//            case TABLE_OF_EXCHANGE_RATE_HISTORY_WITH_TIMESTAMPS:
//                return TableOfExchangeHistoryWithTimestampsScene.create(stage);
//            case US_TO_:
//                return UStoScene.create(stage);
            case INSTRUCTIONS:
                return Instructions.create(stage);
//            case LOGOUT:
//                return LogoutScene.create(stage);

            default:
                throw new IllegalArgumentException("Unknown scene type: " + sceneType );
        }

    }
}




