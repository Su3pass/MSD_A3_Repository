import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.plot.PlotOrientation;  
import org.jfree.chart.plot.XYPlot;  
import org.jfree.data.xy.XYSeries;  
import org.jfree.data.xy.XYSeriesCollection;  
import org.jfree.ui.ApplicationFrame;  
import org.jfree.ui.RefineryUtilities;  
  
import javax.swing.*;  
import java.awt.*;  
  
public class LineChartExample extends ApplicationFrame {  
  
    public LineChartExample(String title) {  
        super(title);  
  
        // Create dataset  
        XYSeries series = new XYSeries("Health Metrics");  
        series.add(1.0, 10.0);  
        series.add(2.0, 15.0);  
        series.add(3.0, 13.0);  
        series.add(4.0, 17.0);  
        series.add(5.0, 16.0);  
  
        XYSeriesCollection dataset = new XYSeriesCollection(series);  
  
        // Create chart  
        JFreeChart chart = ChartFactory.createXYLineChart(  
                "Line Chart Example",  
                "Week Number",  
                "Health Value",  
                dataset,  
                PlotOrientation.VERTICAL,  
                true, true, false);  
  
        // Customize the plot  
        XYPlot plot = chart.getXYPlot();  
        plot.setBackgroundPaint(Color.lightGray);  
        plot.setDomainGridlinePaint(Color.white);  
        plot.setRangeGridlinePaint(Color.white);  
  
        // Create a panel to hold the chart  
        ChartPanel chartPanel = new ChartPanel(chart);  
        chartPanel.setPreferredSize(new Dimension(800, 600));  
        setContentPane(chartPanel);  
    }  
  
    public static void main(String[] args) {  
        SwingUtilities.invokeLater(() -> {  
            LineChartExample example = new LineChartExample("Health Metrics Line Chart");  
            example.pack();  
            RefineryUtilities.centerFrameOnScreen(example);  
            example.setVisible(true);  
        });  
    }  
}