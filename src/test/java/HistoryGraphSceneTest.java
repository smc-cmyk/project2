import javafx.application.Platform;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.data.xy.XYDataset;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HistoryGraphSceneTest {

    private HistoryGraphScene historyGraphScene;
    static Database db;
    private static XYDataset createDataset() {
        TimeSeries sEuro = new TimeSeries("USD to Euro");
        sEuro.add(new Year(1970), 0);
        sEuro.add(new Year(1980), 0);
        sEuro.add(new Year(1990), 0);
        sEuro.add(new Year(1998), 0);
        sEuro.add(new Year(2000), 1.086);
        sEuro.add(new Year(2010), 0.755);
        sEuro.add(new Year(2020), 0.877);
        sEuro.add(new Year(2026), CurrencyConstants.usdToEuro);

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(sEuro);
        return dataset;
    }

    @BeforeAll
    static void beforeAll() {
        Platform.startup(() -> {});

        db = new Database();

    }

    @Test
    @DisplayName("Data set is not empty")
    void testDatasetNotNull() {
        XYDataset dataset = createDataset();
        assertTrue(0<dataset.getItemCount(0));
    }

    @Test
    @DisplayName("Data integrity tested")
    void testDatasetIntegrity() {
        XYDataset dataset = createDataset();
        assertEquals(1,dataset.getSeriesCount());
        assertEquals(8, dataset.getItemCount(0));
    }

    @Test
    @DisplayName("Data is as expected")
    void verifyData() {
        XYDataset dataset = createDataset();
        assertEquals(0, dataset.getYValue(0,0));
        assertEquals(0,dataset.getYValue(0,1));
        assertEquals(1.086,dataset.getYValue(0,4));
    }
}