import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.ui.HorizontalAlignment;
import org.jfree.data.xy.XYDataset;

import java.awt.*;

public class HistoryGraphScene {
    /**
     * Create a graph using historical currency exchange rates.
     */

    private static JFreeChart createChart(XYDataset dataset) {

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Historical Exchange Rates: USD To Currency", //title
                null, //x-axis
                "Year", //y-axis
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

                if (renderer instanceof XYItemRenderer) {
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

    private static XYDataset dataset() {
    }
}
