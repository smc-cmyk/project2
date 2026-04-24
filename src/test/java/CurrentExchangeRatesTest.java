import javafx.application.Platform;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.data.xy.XYDataset;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrentExchangeRatesTest {

    static Database db;

    @BeforeAll
    static void beforeAll() {
        Platform.startup(() -> {});

        db = new Database();

    }

    @Test
    void getCurrency() {

    }

    @Test
    void getExchange() {
    }

    @Test
    void create() {
    }
}