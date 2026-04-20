import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.scene.control.Button;


/**
 * [This is the Scene for conversion from USD to supported currencies. ]
 *
 * @author Kevin Pena Alvarez
 * @version 0.1.0
 * @since 4/15/26
 **/
public class UStoScene {
    public static Scene create(Stage stage) {
        Label label = new Label("USD Converter");
        Label result = new Label();
        TextField USDinput = new TextField();
        USDinput.setPromptText("Enter a value in USD");
        USDinput.setPrefWidth(200);
        final String ERROR_MESSAGE = "Invalid input";


        //creates Button = called "___"
        Button Cad = new Button("CAD");
        Button Eur = new Button("EUR");
        Button Cny = new Button("CNY");
        Button Jpy = new Button("JPY");
        Button Aud = new Button("AUD");
        Button Chf = new Button("CHF");
        Button Cnh = new Button("CNH");
        Button Hkd = new Button("HKD");
        Button Nzd = new Button("NZD");
        Button Return = new Button("Return");

        Cad.setOnAction( e-> { //sets action that happens when button is pressed
            convertCurrency(USDinput,result, "CAD", ERROR_MESSAGE );
        });

        Eur.setOnAction( e-> { //sets action that happens when button is pressed
            convertCurrency(USDinput,result, "EUR", ERROR_MESSAGE );
        });

        Cny.setOnAction( e-> { //sets action that happens when button is pressed
            convertCurrency(USDinput,result, "CNY", ERROR_MESSAGE );
        });

        Jpy.setOnAction( e-> { //sets action that happens when button is pressed
            convertCurrency(USDinput,result, "JPY", ERROR_MESSAGE );
        });

        Aud.setOnAction( e-> { //sets action that happens when button is pressed
            convertCurrency(USDinput,result, "AUD", ERROR_MESSAGE );
        });

        Chf.setOnAction( e-> { //sets action that happens when button is pressed
            convertCurrency(USDinput,result, "CHF", ERROR_MESSAGE );
        });

        Cnh.setOnAction( e-> { //sets action that happens when button is pressed
            convertCurrency(USDinput,result, "CNH", ERROR_MESSAGE );
        });

        Hkd.setOnAction( e-> { //sets action that happens when button is pressed
            convertCurrency(USDinput,result, "HKD", ERROR_MESSAGE );
        });

        Nzd.setOnAction( e-> { //sets action that happens when button is pressed
            convertCurrency(USDinput,result, "NZD", ERROR_MESSAGE );
        });

        Return.setOnAction( e-> {
            SceneFactory.switchScene(stage, SceneType.MAIN_MENU);
        });

        HBox labelbox = new HBox(label);
        HBox row1 = new HBox(20, Cad, Eur, Cny);
        HBox row2 = new HBox(20, Jpy, Aud, Chf);
        HBox row3 = new HBox(20, Cnh, Hkd, Nzd);
        HBox back = new HBox(20, Return);


        labelbox.setAlignment(Pos.TOP_CENTER);
        row1.setAlignment(Pos.CENTER);
        row2.setAlignment(Pos.CENTER);
        row3.setAlignment(Pos.CENTER);
        back.setAlignment(Pos.CENTER);

        VBox root = new VBox(20, label, USDinput, result, row1, row2, row3, back);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(50));

        return new Scene(root, 400,350);

    }

    private static void convertCurrency (TextField USDinput, Label result, String currency,String ERROR_MESSAGE) {
        String input = USDinput.getText();
        try {
            double value = Double.parseDouble(input);
            result.setStyle("-fx-text-fill: black;");
            result.setText("Converted to " + currency +": " + value);
        } catch (NumberFormatException ex) {
            result.setStyle("-fx-text-fill: red;");
            result.setText(ERROR_MESSAGE + ": " +input);
        }

    }

}
