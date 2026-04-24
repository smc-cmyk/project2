import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controller for UStoScene
 *
 * @author Nettra Leandre
 * @version 0.1.0
 * @since 4/20/2026
 */
public class UStoSceneController {
  @FXML private TextField USDinput;
  @FXML private Label result;

  private static final String ERROR_MESSAGE = "Invalid input";

  @FXML
  private void convertToCAD() {
    handleConversion(CurrencyConstants.usdToCad, "CAD");
  }

  @FXML
  private void convertToEUR() {
    handleConversion(CurrencyConstants.usdToEuro, "EUR");
  }

  @FXML
  private void convertToGBP() { handleConversion(CurrencyConstants.usdToPound, "GBP"); }

  @FXML
  private void convertToCNY() {
    handleConversion(CurrencyConstants.usdToYuan, "CNY");
  }

  @FXML
  private void convertToJPY() {
    handleConversion(CurrencyConstants.usdToYen, "JPY");
  }

  private void handleConversion(double rate, String currency) {
    try {
      double usd = Double.parseDouble(USDinput.getText());
      USDConverterResults.convert(usd, rate, currency);

      Stage stage = (Stage) USDinput.getScene().getWindow();
      Database db = new Database();
      SceneFactory factory = new SceneFactory(db);
      stage.setScene(factory.create(SceneType.USD_CONVERTER_RESULT, stage));
      //double converted = usd * rate;

      //result.setText(String.format(
        //  "%.2f USD = %.2f %s",
          //usd, converted, currency
      //));

      //result.setStyle("-fx-text-fill: black;");

    } catch (NumberFormatException e) {
      result.setText(ERROR_MESSAGE);
      result.setStyle("-fx-text-fill: red;");
    }
  }
}
