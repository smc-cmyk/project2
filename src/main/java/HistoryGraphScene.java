import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.ui.HorizontalAlignment;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.data.xy.XYDataset;
import org.jfree.chart.fx.ChartViewer;

import java.awt.*;
/**
 *
 * Creates a time series chart of historical exchange rates.
 * This used jFree-chart 3rd party lib.
 *
 * @author Sean McFerran
 * @version 0.1.0
 * @since 04/14/2026
 */

public class HistoryGraphScene {
    /**
     * Create a graph using historical currency exchange rates.
     */

    private static JFreeChart createChart(XYDataset dataset) {

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Historical Exchange Rates", //title
                null, //x-axis
                "1 USD is equal to...", //y-axis
                dataset);

                String fontName = "Monospaced";
                chart.getTitle().setFont(new Font(fontName, Font.BOLD, 10));

                XYPlot plot = chart.getXYPlot();
                plot.setDomainPannable(true);
                plot.setRangePannable(true);
                plot.setDomainCrosshairVisible(true);
                plot.setRangeCrosshairVisible(true);
                plot.getDomainAxis().setLowerMargin(0.0);

                chart.getLegend().setFrame(BlockBorder.NONE);
                chart.getLegend().setHorizontalAlignment(HorizontalAlignment.CENTER);
                XYItemRenderer renderer = plot.getRenderer();

                if (renderer != null) {
                    XYLineAndShapeRenderer renderer2 = (XYLineAndShapeRenderer) renderer;
                    renderer2.setDefaultShapesVisible(true);
                    renderer2.setDrawSeriesLineAsPath(true);

                    renderer2.setAutoPopulateSeriesStroke(false);
                    renderer2.setDefaultStroke(new BasicStroke(3.0f));
                    renderer2.setSeriesPaint(0, Color.RED);
                    renderer2.setSeriesPaint(1, Color.GREEN);
                    renderer2.setSeriesPaint(2, Color.BLUE);
                    renderer2.setSeriesPaint(3, Color.CYAN);
                    renderer2.setSeriesPaint(4, Color.YELLOW);
                }
                return chart;

    }

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

        TimeSeries sYen = new TimeSeries("USD to Yen in 100s");
        sYen.add(new Year(1970), 3.60);
        sYen.add(new Year(1980), 2.2663);
        sYen.add(new Year(1990), 1.250);
        sYen.add(new Year(2000), 1.078);
        sYen.add(new Year(2010), 0.8777);
        sYen.add(new Year(2020), 1.0675);
        sYen.add(new Year(2026), (CurrencyConstants.usdToYen/100));

        TimeSeries sPound = new TimeSeries("USD to Pound");
        sPound.add(new Year(1970), 0.417);
        sPound.add(new Year(1980), 0.43);
        sPound.add(new Year(1990), 0.56);
        sPound.add(new Year(2000), 0.66);
        sPound.add(new Year(2010), 0.648);
        sPound.add(new Year(2020), 0.78);
        sPound.add(new Year(2026), CurrencyConstants.usdToPound);

        TimeSeries sYuan = new TimeSeries("USD to Yuan");
        sYuan.add(new Year(1970), 2.46);
        sYuan.add(new Year(1980), 1.5);
        sYuan.add(new Year(1990), 4.78);
        sYuan.add(new Year(2000), 8.279);
        sYuan.add(new Year(2010), 6.77);
        sYuan.add(new Year(2020), 6.9);
        sYuan.add(new Year(2026), CurrencyConstants.usdToYuan);

        TimeSeries sCad = new TimeSeries("USD to Cad");
        sCad.add(new Year(1970), 1.044);
        sCad.add(new Year(1980), 1.169);
        sCad.add(new Year(1990), 1.167);
        sCad.add(new Year(2000), 1.486);
        sCad.add(new Year(2010), 1.03);
        sCad.add(new Year(2020), 1.342);
        sCad.add(new Year(2026), CurrencyConstants.usdToCad);

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(sEuro);
        dataset.addSeries(sYen);
        dataset.addSeries(sPound);
        dataset.addSeries(sYuan);
        dataset.addSeries(sCad);
        return dataset;

    }


    public static Scene create(Stage stage) {
        XYDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);
        ChartViewer viewer = new ChartViewer(chart);
        stage.setScene(new Scene(viewer));
        stage.setTitle("Exchange Rate History Graph View");

        javafx.scene.control.Button returnButton = new Button("Return");
        //Return to main menu
        returnButton.setOnAction(e -> {
          Database db = new Database();
          SceneFactory factory = new SceneFactory(db);
          stage.setScene(factory.create(SceneType.MAIN_MENU,stage));
        });

        VBox vBox = new VBox(10,viewer, returnButton);
        vBox.setAlignment(Pos.CENTER);

        return new Scene(vBox, 590, 300);
    }
}
