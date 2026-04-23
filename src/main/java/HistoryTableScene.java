///**
// *
// * Creates a table of the historical exchange rate data.
// * Compare today's exchange rate with those from 1970 to today.
// *
// * @author Sean McFerran
// * @version 0.1.0
// * @since 04/14/2026
// */
//
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.layout.VBox;
//import javafx.scene.text.Font;
//import javafx.stage.Stage;
//
//public class HistoryTableScene {
//
//    private static final String title = "Historic Exchange Rates Table \n 1 USD is Equal to...";
//    //if TableView does not work use this ASCII art table
//    private static final String table = "\n" +
//            "+-------+-------+--------+-------+-------+-------+--------+--------+\n" +
//            "| Year  | 1970  |  1980  | 1990  | 2000  | 2010  |  2020  |  2026  |\n" +
//            "+-------+-------+--------+-------+-------+-------+--------+--------+\n" +
//            "| Euro  |       |        |       | 1.086 | 0.755 |  0.877 |   0.85 |\n" +
//            "| Yen   |   360 | 226.63 | 125.0 | 107.8 | 87.77 | 106.75 | 158.72 |\n" +
//            "| Pound | 0.417 |   0.43 |  0.56 |  0.66 | 0.648 |   0.78 |   0.74 |\n" +
//            "| Yuan  |  2.46 |    1.5 |  4.78 | 8.279 |  6.77 |    6.9 |   6.82 |\n" +
//            "| CAD   | 1.044 |  1.169 | 1.167 | 1.486 |  1.03 |  1.342 |   1.38 |\n" +
//            "+-------+-------+--------+-------+-------+-------+--------+--------+\n" +
//            "\n";
//    public static Scene create(Stage stage) {
//
//        SceneFactory sceneFactory = new SceneFactory();
//
//        Label titleLabel = new Label(title);
//        Label tableLabel = new Label(table);
//        Label timeLabel = new Label("Data retrieved at: " + CurrencyConstants.dateOfRetrieval);
//        tableLabel.setFont(Font.font("Monospaced", 12));
//        Button backButton = new Button("Return");
//
//        backButton.setOnAction(e -> {
//            stage.setScene(sceneFactory.create(SceneType.MAIN_MENU, stage));
//        });
//
//        VBox vBox = new VBox(10, titleLabel, tableLabel, timeLabel, backButton);
//        vBox.setAlignment(Pos.CENTER);
//
//        //return newly created scene
//        return new Scene(vBox, 590, 300);
//    }
//}
