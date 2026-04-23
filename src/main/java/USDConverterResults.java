import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;

/**
 * [Description]
 *
 * @author Kevin Pena Alvarez
 * @version 0.1.0
 * @since 4/23/26
 **/
public class USDConverterResults {
    private static final String historyTitleLabel = "History:";
    private static String result = "";
    private static final List<String> history = new ArrayList<>();

    public static void convert( double usd, double rate, String currency) {
        if (!result.isEmpty()){
            history.add(0, result);
        }

        double converted = usd * rate;
        result = String.format("%.2f USD = %.2f %s", usd, converted, currency);

        if (history.size() > 3) {
            history.remove(3);
        }
    }

    public static Scene create(Stage stage) {
        stage.setTitle("USD Converter Results");

        Database db = new Database();
        SceneFactory sceneFactory = new SceneFactory(db);
        Label conversionLabel = new Label(result);
        Label historyLabel = new Label(historyTitleLabel);

        Label history_1 = new Label(history.size() > 0 ? history.get(0) : "");
        Label history_2 = new Label(history.size() > 1 ? history.get(1) : "");
        Label history_3 = new Label(history.size() > 2 ? history.get(2) : "");
        Button returnButton = new Button("Return");
        Button mainMenuButton = new Button("Menu");

        returnButton.setOnAction(actionEvent -> {
            stage.setScene(sceneFactory.create(SceneType.US_TO_, stage));

        });

        mainMenuButton.setOnAction(actionEvent -> {
                stage.setScene(sceneFactory.create(SceneType.MAIN_MENU, stage));

        });

        VBox vbox = new VBox(10, conversionLabel,
                historyLabel,
                history_1,
                history_2,
                history_3,
                returnButton);
        vbox.setAlignment(Pos.CENTER);

        HBox topBar = new HBox(mainMenuButton);
        topBar.setAlignment(Pos.TOP_RIGHT);
        topBar.setPadding(new Insets(10));

        BorderPane root = new BorderPane();
        root.setCenter(vbox);
        root.setTop(topBar);


        return new Scene(root, 400, 300);
    }
}
