import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
    convert(CurrencyConstants.usdToCad, "CAD");
  }

  @FXML
  private void convertToEUR() {
    convert(CurrencyConstants.usdToEuro, "EUR");
  }

  @FXML
  private void convertToCNY() {
    convert(CurrencyConstants.usdToYuan, "CNY");
  }

  @FXML
  private void convertToJPY() {
    convert(CurrencyConstants.usdToYen, "JPY");
  }

  private void convert(double rate, String currency) {
    try {
      double usd = Double.parseDouble(USDinput.getText());
      double converted = usd * rate;

      result.setText(String.format(
          "%.2f USD = %.2f %s",
          usd, converted, currency
      ));

      result.setStyle("-fx-text-fill: black;");

    } catch (NumberFormatException e) {
      result.setText(ERROR_MESSAGE);
      result.setStyle("-fx-text-fill: red;");
    }
  }
}
